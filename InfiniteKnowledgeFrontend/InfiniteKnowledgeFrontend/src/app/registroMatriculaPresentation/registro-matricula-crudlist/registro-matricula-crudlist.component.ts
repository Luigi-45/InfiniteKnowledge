import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudiante } from 'src/app/entities/estudiante';
import { GradoSeccion } from 'src/app/entities/grado-seccion';
import { RegistroMatricula } from 'src/app/entities/registro-matricula';
import { RegistroMatriculaForList } from 'src/app/entities/registro-matricula-for-list';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';
import { GradoSeccionGatewayService } from 'src/app/gateways/grado-seccion-gateway.service';
import { RegistroMatriculaGatewayService } from 'src/app/gateways/registro-matricula-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registro-matricula-crudlist',
  templateUrl: './registro-matricula-crudlist.component.html',
  styleUrls: ['./registro-matricula-crudlist.component.css']
})
export class RegistroMatriculaCRUDListComponent implements OnInit{
  registrosMatricula: RegistroMatricula[];
  registrosMatriculaForList:RegistroMatriculaForList[] = [];

  estudiante: Estudiante;

  gradoSeccion: GradoSeccion;
  listaGradoSeccion: GradoSeccion[];

  gradoSeccionSeleccionada:string;
  gradoSeccionId: number;
  

  constructor(private estudianteGateway:EstudianteGatewayService, private gradoSeccionGateway: GradoSeccionGatewayService, 
    private registroMatriculaGateway:RegistroMatriculaGatewayService, private router:Router){}

  ngOnInit(): void {
    this.gradoSeccionGateway.findAll().subscribe(data => {
      this.listaGradoSeccion = data;
    });
  }

  private findAll(){
    this.registrosMatriculaForList = [];

    this.registroMatriculaGateway.findAllByGradoSeccion(this.gradoSeccionId).subscribe(data => {
      this.registrosMatricula = data;

      this.registrosMatricula.forEach((rm) => {

        var registroMatriculaForList = new RegistroMatriculaForList();
        registroMatriculaForList.registroMatriculaId = rm.registroMatriculaId;
        registroMatriculaForList.nombrePaqueteCurso = rm.nombrePaqueteCurso;

        this.estudianteGateway.findById(rm.estudianteId).subscribe(data => {
          this.estudiante = data;
          registroMatriculaForList.estudiante = this.estudiante.nombre+" "+this.estudiante.apellido;
          
          this.gradoSeccionGateway.findById(rm.gradoSeccionId).subscribe(data => {
            this.gradoSeccion = data;
            registroMatriculaForList.gradoSeccion = this.gradoSeccion.grado+this.gradoSeccion.seccion;

            this.registrosMatriculaForList.push(registroMatriculaForList);

            this.updateTable();
          });
        });
  
      });
      
    });
  }

  selectGradoSeccion(){
    const optionsArray:string[] = [];
    this.listaGradoSeccion.forEach((gradoSeccion) => {
      optionsArray.push(gradoSeccion.grado+gradoSeccion.seccion);
    });

    const inputOptions:{ [key:string]:string } = {};
    optionsArray.forEach((option:string, index:number) => {
      inputOptions[`option${index + 1}`] = option;
    });

    const inputValidator: (inputValue: string) => Promise<string | null> = async (value: string) => {
      if (!value) {
        return "Debes seleccionar un grado y sección";
      }
      return null;
    };
  
    Swal.fire({
      title: 'Selecciona un grado y sección',
      input: 'select',
      inputOptions: inputOptions,
      showCancelButton: true,
      inputValidator,
    }).then((result) => {
      if (result.isConfirmed) {
        this.gradoSeccionSeleccionada = inputOptions[result.value];

        this.findGradoSeccionByName();

        Swal.fire(
          'Grado y sección seleccionado',
          'El Grado y sección '+inputOptions[result.value]+' ha sido seleccionado con exito',
          'success'
        )
      }
    });
  }

  findGradoSeccionByName(){
    this.listaGradoSeccion.forEach(gradoSeccion => {
      if(gradoSeccion.grado+gradoSeccion.seccion===this.gradoSeccionSeleccionada){
        this.gradoSeccionId = gradoSeccion.gradoSeccionId;
      }
    })
  }

  searchOptionByGradoSeccion(){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas buscar con ese grado y sección",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si , buscar',
      cancelButtonText: 'No, cancelar',
      customClass: {
        confirmButton: 'btn btn-success', 
        cancelButton: 'btn btn-danger',
      },
      buttonsStyling: true
    }).then((result) => {
      if(result.value){

        this.findAll();
        
        Swal.fire(
          'Búsqueda satisfactoria',
          'Los registros de matrícula fueron hallados con éxito',
          'success'
        )
      }
    });
  }

  updateTable(){
    const tabla = document.getElementById('tablaRegistroMatricula');
    if(tabla){
      tabla.innerHTML = '';
    }

    const tableHead = document.createElement('thead');
    tableHead.classList.add('table-dark');

    const trHead = document.createElement('tr');

    var thHead = document.createElement('th')
    thHead.innerHTML = 'Id';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Estudiante';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Grado y Sección';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Paquete';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Actions';
    trHead.appendChild(thHead);

    tableHead.appendChild(trHead);

    if(tabla){
      tabla.appendChild(tableHead);
      
    }

    const tBody = document.createElement('tbody');
  
    this.registrosMatriculaForList.forEach((item) => {
      
      var trBody = document.createElement('tr');

      var tdBody = document.createElement('td');
      tdBody.innerHTML = item.registroMatriculaId.toString();
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');
      tdBody.innerHTML = item.estudiante;
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');
      tdBody.innerHTML = item.gradoSeccion;
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');
      tdBody.innerHTML = item.nombrePaqueteCurso;
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');

      var buttonModify = document.createElement('button');
      buttonModify.classList.add('btn', 'btn-info');
      buttonModify.textContent = 'Update';
      buttonModify.addEventListener('click', () => {
        this.modifyRegistroMatricula(item.registroMatriculaId);
      });
      tdBody.appendChild(buttonModify);

      var buttonDelete = document.createElement('button');
      buttonDelete.classList.add('btn', 'btn-danger');
      buttonDelete.textContent = 'Delete';
      buttonDelete.style.marginLeft = '10px';
      buttonDelete.addEventListener('click', () => {
        this.deleteRegistroMatricula(item.registroMatriculaId);
      });
      tdBody.appendChild(buttonDelete);

      var buttonInfo = document.createElement('button');
      buttonInfo.classList.add('btn', 'btn-primary');
      buttonInfo.textContent = 'Info';
      buttonInfo.style.marginLeft = '10px';
      buttonInfo.addEventListener('click', () => {
        this.infoRegistroMatricula(item.registroMatriculaId);
      });
      tdBody.appendChild(buttonInfo);

      trBody.appendChild(tdBody);

      tBody.appendChild(trBody);
    });

    if(tabla){
      tabla.appendChild(tBody);
    }
  }

  createRegistroMatricula(){
    this.router.navigate(['/registroMatricula/guardar']);
  }

  modifyRegistroMatricula(registroMatriculaId:number){
    this.router.navigate(['/registroMatricula/modificar'], { queryParams: { registroMatriculaId:registroMatriculaId } });
  }

  infoRegistroMatricula(registroMatriculaId:number){
    this.router.navigate(['/registroMatricula/info'], { queryParams: { registroMatriculaId:registroMatriculaId } });
  }

  deleteRegistroMatricula(registroMatriculaId:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas eliminar el registro de matrícula",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si , elimínalo',
      cancelButtonText: 'No, cancelar',
      customClass: {
        confirmButton: 'btn btn-success', 
        cancelButton: 'btn btn-danger',
      },
      buttonsStyling: true
    }).then((result) => {
      if(result.value){
        this.registroMatriculaGateway.delete(registroMatriculaId).subscribe(data => {
          console.log(data);
          this.findAll();
          Swal.fire(
            'Registro de matrícula eliminado',
            'La registro de matrícula ha sido eliminado con exito',
            'success'
          )
        })
      }
    });
  }
}
