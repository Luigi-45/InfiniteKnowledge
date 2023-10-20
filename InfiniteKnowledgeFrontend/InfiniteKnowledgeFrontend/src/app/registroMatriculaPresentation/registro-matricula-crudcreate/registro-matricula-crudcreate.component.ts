import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudiante } from 'src/app/entities/estudiante';
import { GradoSeccion } from 'src/app/entities/grado-seccion';
import { RegistroMatricula } from 'src/app/entities/registro-matricula';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';
import { GradoSeccionGatewayService } from 'src/app/gateways/grado-seccion-gateway.service';
import { RegistroMatriculaGatewayService } from 'src/app/gateways/registro-matricula-gateway.service';
import Swal from 'sweetalert2';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-registro-matricula-crudcreate',
  templateUrl: './registro-matricula-crudcreate.component.html',
  styleUrls: ['./registro-matricula-crudcreate.component.css']
})
export class RegistroMatriculaCRUDCreateComponent implements OnInit{
  registroMatricula:RegistroMatricula;

  listaEstudiantes:Estudiante[];
  listaGradoSeccion:GradoSeccion[];

  estudianteSeleccionado:string = "";
  gradoSeccionSeleccionada:string = "";
  estudianteId:number=0;
  gradoSeccionId:number=0;

  constructor(private estudianteGateway:EstudianteGatewayService, private gradoSeccionGateway:GradoSeccionGatewayService,
    private registroMatriculaGateway:RegistroMatriculaGatewayService, private router:Router, private cookieService: CookieService){}

  ngOnInit(): void {
    this.registroMatricula = new RegistroMatricula();

    this.estudianteGateway.findAll().subscribe(data => {
      this.listaEstudiantes = data;
    })

    this.gradoSeccionGateway.findAll().subscribe(data => {
      this.listaGradoSeccion = data;
    })
  }

  saveRegistroMatricula(){
    this.registroMatricula.estudianteId = this.estudianteId;
    this.registroMatricula.gradoSeccionId = this.gradoSeccionId;

    this.registroMatriculaGateway.save(this.registroMatricula).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/registroMatricula']);
    Swal.fire('La matrícula ha sido registrada',`El matrícula ha sido registrada satisfactoriamente`);
  }

  onSubmit(){
    this.saveRegistroMatricula();
  }

  findStudentByName(){
    this.listaEstudiantes.forEach(estudiante => {
      if(estudiante.nombre+" "+estudiante.apellido===this.estudianteSeleccionado){
        this.estudianteId = estudiante.estudianteId;
      }
    })
  }

  findGradoSeccionByName(){
    this.listaGradoSeccion.forEach(gradoSeccion => {
      if(gradoSeccion.grado+gradoSeccion.seccion===this.gradoSeccionSeleccionada){
        this.gradoSeccionId = gradoSeccion.gradoSeccionId;
      }
    })
  }

  selectStudent(){
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });
    
    Swal.fire({
      title: 'Busque el estudiante por nombre',
      input: 'text',
      inputAttributes: {
        autocapitalize: 'off'
      },
      showCancelButton: true,
      confirmButtonText: 'Buscar',
      showLoaderOnConfirm: true,
      preConfirm: (nombre) => {
        return fetch(`http://localhost:8082/api/estudiante/findByFullName?nombre=${nombre}`, { headers })
          .then(response => {
            if (!response.ok) {
              throw new Error(response.statusText)
            }
            return response.json()
          })
          .catch(error => {
            Swal.showValidationMessage(
              `Búsqueda fallida: ${error}`
            )
          })
      },
      allowOutsideClick: () => !Swal.isLoading()
    }).then((result) => {
      if (result.isConfirmed) {
        const arrayData = result.value as Estudiante[];

        const optionsArray:string[] = [];
        
        arrayData.forEach((estudiante) => {
          optionsArray.push(estudiante.nombre+" "+estudiante.apellido);
        });
    
        const inputOptions:{ [key:string]:string } = {};
        optionsArray.forEach((option:string, index:number) => {
          inputOptions[`option${index + 1}`] = option;
        });
    
        const inputValidator: (inputValue: string) => Promise<string | null> = async (value: string) => {
          if (!value) {
            return "Debes seleccionar un estudiante";
          }
          return null;
        };
      
        Swal.fire({
          title: 'Selecciona un estudiante',
          input: 'select',
          inputOptions: inputOptions,
          showCancelButton: true,
          inputValidator,
        }).then((result) => {
          if (result.isConfirmed) {
            this.estudianteSeleccionado = inputOptions[result.value];
    
            this.findStudentByName();
    
            Swal.fire(
              'Estudiante seleccionado',
              'El estudiante '+inputOptions[result.value]+' ha sido seleccionado con exito',
              'success'
            )
          }
        });

      }
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
}
