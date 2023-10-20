import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DocenteCursoForList } from 'src/app/entities/docente-curso-for-list';
import { Estudiante } from 'src/app/entities/estudiante';
import { RegistroCalificacion } from 'src/app/entities/registro-calificacion';
import { DocenteCursoGatewayService } from 'src/app/gateways/docente-curso-gateway.service';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';
import { RegistroCalificacionGatewayService } from 'src/app/gateways/registro-calificacion-gateway.service';
import Swal from 'sweetalert2';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-registro-calificacion-crudcreate',
  templateUrl: './registro-calificacion-crudcreate.component.html',
  styleUrls: ['./registro-calificacion-crudcreate.component.css']
})
export class RegistroCalificacionCRUDCreateComponent {
  listaEstudiantes:Estudiante[];

  docentesCurso:DocenteCursoForList[] = [];

  estudianteSeleccionado:string = "";
  docenteCursoSeleccionado:string = "";
  estudianteId:number=0;
  docenteCursoId:number=0;

  constructor(private estudianteGateway:EstudianteGatewayService, private docenteCursoGateway:DocenteCursoGatewayService, 
    private registroCalificacionGateway:RegistroCalificacionGatewayService, private router:Router, private cookieService: CookieService){}

  ngOnInit(): void {
    this.estudianteGateway.findAll().subscribe(data => {
      this.listaEstudiantes = data;
    })

    this.docenteCursoGateway.findNames().subscribe(data => {
      data.forEach((element) => {
        var docenteCursoForList = new DocenteCursoForList();

        docenteCursoForList.docenteCursoId = Number(element[0]);
        docenteCursoForList.docenteNombre = element[1].toString();
        docenteCursoForList.cursoNombre = element[2].toString();

        this.docentesCurso.push(docenteCursoForList);
      });
    });
  }

  saveRegistroCalificacion(){
    var registrosCalificacion:RegistroCalificacion[] = [];

    for(let i=1; i<5; i++){
      var registroCal = new RegistroCalificacion();

      registroCal.estudianteId = this.estudianteId;
      registroCal.docenteCursoId = this.docenteCursoId;
      registroCal.calificacion1 = 0;
      registroCal.calificacion2 = 0;
      registroCal.calificacion3 = 0;
      registroCal.calificacion4 = 0;
      registroCal.bimestre = i;

      registrosCalificacion.push(registroCal);
    }

    this.registroCalificacionGateway.save(registrosCalificacion).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/registroCalificacion']);
    Swal.fire('La calificación ha sido registrada',`El calificación ha sido registrada satisfactoriamente`);
  }

  onSubmit(){
    this.saveRegistroCalificacion();
  }

  findStudentByName(){
    this.listaEstudiantes.forEach(estudiante => {
      if(estudiante.nombre+" "+estudiante.apellido===this.estudianteSeleccionado){
        this.estudianteId = estudiante.estudianteId;
      }
    })
  }

  findDocenteCurso(){
    this.docentesCurso.forEach(docenteCurso => {
      if(docenteCurso.docenteNombre+' - '+docenteCurso.cursoNombre===this.docenteCursoSeleccionado){
        this.docenteCursoId = docenteCurso.docenteCursoId;
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
        return fetch(`http://localhost:8082/api/estudiante/findByFullName?nombre=${nombre}`, {headers})
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

  selectDocenteCurso(){
    const optionsArray:string[] = [];
    this.docentesCurso.forEach((docenteCurso) => {
      optionsArray.push(docenteCurso.docenteNombre+' - '+docenteCurso.cursoNombre);
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
}
