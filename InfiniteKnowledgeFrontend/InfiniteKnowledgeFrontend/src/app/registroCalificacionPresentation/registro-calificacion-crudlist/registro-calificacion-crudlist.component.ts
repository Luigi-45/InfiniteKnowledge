import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudiante } from 'src/app/entities/estudiante';
import { RegistroCalificacion } from 'src/app/entities/registro-calificacion';
import { RegistroCalificacionForList } from 'src/app/entities/registro-calificacion-for-list';
import { DocenteCursoGatewayService } from 'src/app/gateways/docente-curso-gateway.service';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';
import { RegistroCalificacionGatewayService } from 'src/app/gateways/registro-calificacion-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registro-calificacion-crudlist',
  templateUrl: './registro-calificacion-crudlist.component.html',
  styleUrls: ['./registro-calificacion-crudlist.component.css']
})
export class RegistroCalificacionCRUDListComponent implements OnInit{
  estudiantes:Estudiante[];
  registrosCalificacion: RegistroCalificacionForList[] = [];
  reportes:Object[][] = [];
  docenteCurso:Object[][];

  docenteCursoSeleccionado:string;
  docenteCursoId: number;

  bimestre:string[] = ["1","2","3","4"];
  bimestreSeleccionado:string;
  
  constructor(private estudianteGateway:EstudianteGatewayService, private docenteCursoGateway: DocenteCursoGatewayService, 
    private registroCalificacionGateway:RegistroCalificacionGatewayService, private router:Router){}

  ngOnInit(): void {
    this.docenteCursoGateway.findNames().subscribe(data => {
      this.docenteCurso = data;

      this.docenteCurso.forEach((element) => {
        element[0] = Number(element[0]);
        element[1] = element[1].toString();
        element[2] = element[2].toString();
      });

      this.estudianteGateway.findAll().subscribe(data => {
        this.estudiantes = data;
      });
    });

  }

  private findAll(){
    this.registrosCalificacion = [];
    this.reportes = [];

    this.registroCalificacionGateway.findAllByDocenteCursoBimestre(this.docenteCursoId,Number(this.bimestreSeleccionado)).subscribe(data2 => {
      
      data2.forEach((dc) => {
        var listaObjetos:Object[] = [];
        var registroCalificacion = new RegistroCalificacionForList();

        registroCalificacion.registroCalifacionId = dc.registroCalificacionId;
        registroCalificacion.calificacion1 = dc.calificacion1;
        registroCalificacion.calificacion2 = dc.calificacion2;
        registroCalificacion.calificacion3 = dc.calificacion3;
        registroCalificacion.calificacion4 = dc.calificacion4;
        registroCalificacion.bimestre = dc.bimestre;

        listaObjetos.push(registroCalificacion.registroCalifacionId);
        
        this.docenteCurso.forEach((element) => {
          if(dc.docenteCursoId == element[0]){
            registroCalificacion.docenteCurso = element[1] + " - " + element[2];
          }
        });

        this.estudiantes.forEach((element) => {
          if(dc.estudianteId == element.estudianteId){
            registroCalificacion.estudiante = element.nombre + " " + element.apellido;

            listaObjetos.push(registroCalificacion.estudiante);
          }
        });

        listaObjetos.push(registroCalificacion.docenteCurso);
        listaObjetos.push(registroCalificacion.calificacion1);
        listaObjetos.push(registroCalificacion.calificacion2);
        listaObjetos.push(registroCalificacion.calificacion3);
        listaObjetos.push(registroCalificacion.calificacion4);
        listaObjetos.push((registroCalificacion.calificacion1+registroCalificacion.calificacion2+registroCalificacion.calificacion3+registroCalificacion.calificacion4)/4);
        listaObjetos.push(registroCalificacion.bimestre);

        this.registrosCalificacion.push(registroCalificacion);
        this.reportes.push(listaObjetos);
      });

      this.updateTable();
      
    });
  }

  selectDocenteCurso(){
    const optionsArray:string[] = [];
    this.docenteCurso.forEach((docenteCurso) => {
      optionsArray.push(docenteCurso[1]+' - '+docenteCurso[2]);
    });

    const inputOptions:{ [key:string]:string } = {};
    optionsArray.forEach((option:string, index:number) => {
      inputOptions[`option${index + 1}`] = option;
    });

    const inputValidator: (inputValue: string) => Promise<string | null> = async (value: string) => {
      if (!value) {
        return "Debes seleccionar un docente-curso";
      }
      return null;
    };
  
    Swal.fire({
      title: 'Selecciona un docente-curso',
      input: 'select',
      inputOptions: inputOptions,
      showCancelButton: true,
      inputValidator,
    }).then((result) => {
      if (result.isConfirmed) {
        this.docenteCursoSeleccionado = inputOptions[result.value];

        this.findDocenteCurso();

        Swal.fire(
          'Docente-curso seleccionado',
          'El docente-curso '+inputOptions[result.value]+' ha sido seleccionado con exito',
          'success'
        )
      }
    });
  }

  findDocenteCurso(){
    this.docenteCurso.forEach(docenteCurso => {
      if(docenteCurso[1]+' - '+docenteCurso[2]===this.docenteCursoSeleccionado){
        this.docenteCursoId = Number(docenteCurso[0]);
      }
    })
  }

  selectBimestre(){
    const inputOptions:{ [key:string]:string } = {};
    this.bimestre.forEach((option:string, index:number) => {
      inputOptions[`option${index + 1}`] = option;
    });

    const inputValidator: (inputValue: string) => Promise<string | null> = async (value: string) => {
      if (!value) {
        return "Debes seleccionar un bimestre";
      }
      return null;
    };
  
    Swal.fire({
      title: 'Selecciona un bimestre',
      input: 'select',
      inputOptions: inputOptions,
      showCancelButton: true,
      inputValidator,
    }).then((result) => {
      if (result.isConfirmed) {
        this.bimestreSeleccionado = inputOptions[result.value];

        Swal.fire(
          'Bimestre seleccionado',
          'El bimestre '+inputOptions[result.value]+' ha sido seleccionado con exito',
          'success'
        )
      }
    });
  }

  searchOptionByDocenteCursoBimestre(){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas buscar con ese docente-curso y bimestre",
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
          'Los registros de calificación fueron hallados con éxito',
          'success'
        )
      }
    });
  }

  updateTable(){
    const tabla = document.getElementById('tablaRegistroCalificacion');
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
    thHead.innerHTML = 'Docente-Curso';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Calif. 1';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Calif. 2';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Calif. 3';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Calif. 4';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Promedio';
    trHead.appendChild(thHead);

    thHead = document.createElement('th')
    thHead.innerHTML = 'Actions';
    trHead.appendChild(thHead);

    tableHead.appendChild(trHead);

    if(tabla){
      tabla.appendChild(tableHead);
      
    }

    const tBody = document.createElement('tbody');
  
    this.registrosCalificacion.forEach((item) => {
      
      var trBody = document.createElement('tr');

      var tdBody = document.createElement('td');
      tdBody.innerHTML = item.registroCalifacionId.toString();
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');
      tdBody.innerHTML = item.estudiante;
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');
      tdBody.innerHTML = item.docenteCurso;
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');
      var inputValue = document.createElement('input');
      inputValue.setAttribute('type', 'text');
      inputValue.setAttribute('value', item.calificacion1.toString());
      inputValue.addEventListener('input', (event) => {
        const value = Number((event.target as HTMLInputElement).value);
        item.calificacion1 = value;
      });
      tdBody.appendChild(inputValue);
      trBody.appendChild(tdBody);
      
      tdBody = document.createElement('td');
      inputValue = document.createElement('input');
      inputValue.setAttribute('type', 'text');
      inputValue.setAttribute('value', item.calificacion2.toString());
      inputValue.addEventListener('input', (event) => {
        const value = Number((event.target as HTMLInputElement).value);
        item.calificacion2 = value;
      });
      tdBody.appendChild(inputValue);
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');
      inputValue = document.createElement('input');
      inputValue.setAttribute('type', 'text');
      inputValue.setAttribute('value', item.calificacion3.toString());
      inputValue.addEventListener('input', (event) => {
        const value = Number((event.target as HTMLInputElement).value);
        item.calificacion3 = value;
      });
      tdBody.appendChild(inputValue);
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');
      inputValue = document.createElement('input');
      inputValue.setAttribute('type', 'text');
      inputValue.setAttribute('value', item.calificacion4.toString());
      inputValue.addEventListener('input', (event) => {
        const value = Number((event.target as HTMLInputElement).value);
        item.calificacion4 = value;
      });
      tdBody.appendChild(inputValue);
      trBody.appendChild(tdBody);
      
      tdBody = document.createElement('td');
      tdBody.innerHTML = ((item.calificacion1+item.calificacion2+item.calificacion3+item.calificacion4)/4).toString();
      trBody.appendChild(tdBody);

      tdBody = document.createElement('td');

      var buttonDelete = document.createElement('button');
      buttonDelete.classList.add('btn', 'btn-danger');
      buttonDelete.textContent = 'Delete';
      buttonDelete.style.marginLeft = '10px';
      buttonDelete.addEventListener('click', () => {
        this.deleteRegistroCalificacion(item.registroCalifacionId);
      });
      tdBody.appendChild(buttonDelete);

      var buttonInfo = document.createElement('button');
      buttonInfo.classList.add('btn', 'btn-primary');
      buttonInfo.textContent = 'Info';
      buttonInfo.style.marginLeft = '10px';
      buttonInfo.addEventListener('click', () => {
        this.infoRegistroCalificacion(item.registroCalifacionId);
      });
      tdBody.appendChild(buttonInfo);

      trBody.appendChild(tdBody);

      tBody.appendChild(trBody);
    });

    var buttonSave = document.createElement('button');
    buttonSave.classList.add('btn', 'btn-info');
    buttonSave.textContent = 'Save';
    buttonSave.addEventListener('click', () => {
      this.saveRegistrosCalificacion();
    });

    var buttonExportarPdf = document.createElement('button');
    buttonExportarPdf.classList.add('btn', 'btn-warning');
    buttonExportarPdf.textContent = 'Export PDF';
    buttonExportarPdf.addEventListener('click', () => {
      this.exportPdf();
    });

    var buttonExportarExcel = document.createElement('button');
    buttonExportarExcel.classList.add('btn', 'btn-success');
    buttonExportarExcel.textContent = 'Export Excel';
    buttonExportarExcel.addEventListener('click', () => {
      this.exportExcel();
    });

    if(tabla){
      tabla.appendChild(tBody);
      tabla.appendChild(buttonSave);
      tabla.appendChild(buttonExportarPdf);
      tabla.appendChild(buttonExportarExcel);
    }
  }
  
  exportPdf(){
    this.registroCalificacionGateway.generatePdf(this.reportes);

    Swal.fire(
      'Descarga de PDF satisfactoria',
      'Los registros de calificación fueron descargados con éxito en PDF',
      'success'
    )
  }

  exportExcel(){
    this.registroCalificacionGateway.generateExcel(this.reportes);

    Swal.fire(
      'Descarga de Excel satisfactoria',
      'Los registros de calificación fueron descargados con éxito en Excel',
      'success'
    )
  }

  createRegistroCalificacion(){
    this.router.navigate(['/registroCalificacion/guardar']);
  }

  saveRegistrosCalificacion(){
    var registrosCalificacionOriginales:RegistroCalificacion[] = [];
    this.registrosCalificacion.forEach(rc => {
      
      
      var registroCalifNuevo = new RegistroCalificacion();
      registroCalifNuevo.registroCalificacionId = rc.registroCalifacionId;
      registroCalifNuevo.calificacion1 = rc.calificacion1;
      registroCalifNuevo.calificacion2 = rc.calificacion2;
      registroCalifNuevo.calificacion3 = rc.calificacion3;
      registroCalifNuevo.calificacion4 = rc.calificacion4;
      registroCalifNuevo.bimestre = rc.bimestre;

      this.estudiantes.forEach((estudiante) => {
        if(estudiante.nombre+" "+estudiante.apellido===rc.estudiante){
          registroCalifNuevo.estudianteId = estudiante.estudianteId;
        }
      });

      this.docenteCurso.forEach((dc) => {
        if(rc.docenteCurso === dc[1]+ " - "+dc[2]){
          registroCalifNuevo.docenteCursoId = Number(dc[0]);
        }
      });

        registrosCalificacionOriginales.push(registroCalifNuevo);
      });
    
    this.registroCalificacionGateway.save(registrosCalificacionOriginales).subscribe((data) => {
      this.findAll();
    }, error => console.log(error));
  }

  infoRegistroCalificacion(registroCalificacionId:number){
    this.router.navigate(['/registroCalificacion/info'], { queryParams: { registroCalificacionId:registroCalificacionId } });
  }

  deleteRegistroCalificacion(registroCalificacionId:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas eliminar el registro de calificación",
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
        this.registroCalificacionGateway.delete(registroCalificacionId).subscribe(data => {
          console.log(data);
          this.findAll();
          Swal.fire(
            'Registro de calificación eliminado',
            'La registro de calificación ha sido eliminado con exito',
            'success'
          )
        })
      }
    });
  }
}
