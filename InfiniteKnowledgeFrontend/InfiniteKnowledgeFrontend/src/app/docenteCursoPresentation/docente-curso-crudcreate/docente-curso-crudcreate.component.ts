import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Curso } from 'src/app/entities/curso';
import { Docente } from 'src/app/entities/docente';
import { DocenteCurso } from 'src/app/entities/docente-curso';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';
import { DocenteCursoGatewayService } from 'src/app/gateways/docente-curso-gateway.service';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-docente-curso-crudcreate',
  templateUrl: './docente-curso-crudcreate.component.html',
  styleUrls: ['./docente-curso-crudcreate.component.css']
})
export class DocenteCursoCRUDCreateComponent implements OnInit{
  docenteCurso:DocenteCurso;
  listaDocentes:Docente[];
  listaCursos:Curso[];

  cursoSeleccionado:string = "";
  docenteSeleccionado:string = "";
  cursoId:number=0;
  docenteId:number=0;

  constructor(private docenteGateway:DocenteGatewayService, private cursoGateway:CursoGatewayService,
    private docenteCursoGateway:DocenteCursoGatewayService, private router:Router){}

  ngOnInit(): void {
    this.docenteCurso = new DocenteCurso();

    this.docenteGateway.findAll().subscribe(data => {
      this.listaDocentes = data;
    })

    this.cursoGateway.findAll().subscribe(data => {
      this.listaCursos = data;
    })
  }

  saveDocenteCurso(){
    this.docenteCurso.docenteId = this.docenteId;
    this.docenteCurso.cursoId = this.cursoId;

    this.docenteCursoGateway.save(this.docenteCurso).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/docenteCurso']);
    Swal.fire('La asignación docente-curso ha sido registrada',`El asignación docente-curso ha sido registrada satisfactoriamente`);
  }

  onSubmit(){
    this.saveDocenteCurso();
  }

  findTeacherByName(){
    this.listaDocentes.forEach(docente => {
      if(docente.nombre+" "+docente.apellido===this.docenteSeleccionado){
        this.docenteId = docente.docenteId;
      }
    })
  }

  findCourseByName(){
    this.listaCursos.forEach(curso => {
      if(curso.nombre===this.cursoSeleccionado){
        this.cursoId = curso.cursoId;
      }
    })
  }

  selectTeacher(){
    const optionsArray:string[] = [];
    this.listaDocentes.forEach((docente) => {
      optionsArray.push(docente.nombre+" "+docente.apellido);
    });

    const inputOptions:{ [key:string]:string } = {};
    optionsArray.forEach((option:string, index:number) => {
      inputOptions[`option${index + 1}`] = option;
    });

    const inputValidator: (inputValue: string) => Promise<string | null> = async (value: string) => {
      if (!value) {
        return "Debes seleccionar un docente";
      }
      return null;
    };
  
    Swal.fire({
      title: 'Selecciona un docente',
      input: 'select',
      inputOptions: inputOptions,
      showCancelButton: true,
      inputValidator,
    }).then((result) => {
      if (result.isConfirmed) {
        this.docenteSeleccionado = inputOptions[result.value];
        
        this.findTeacherByName();
        
        Swal.fire(
          'Docente seleccionado',
          'El docente '+inputOptions[result.value]+' ha sido seleccionado con exito',
          'success'
        )
      }
    });
  }

  selectCourse(){
    const optionsArray:string[] = [];
    this.listaCursos.forEach((curso) => {
      optionsArray.push(curso.nombre);
    });

    const inputOptions:{ [key:string]:string } = {};
    optionsArray.forEach((option:string, index:number) => {
      inputOptions[`option${index + 1}`] = option;
    });

    const inputValidator: (inputValue: string) => Promise<string | null> = async (value: string) => {
      if (!value) {
        return "Debes seleccionar un curso";
      }
      return null;
    };
  
    Swal.fire({
      title: 'Selecciona un curso',
      input: 'select',
      inputOptions: inputOptions,
      showCancelButton: true,
      inputValidator,
    }).then((result) => {
      if (result.isConfirmed) {
        this.cursoSeleccionado = inputOptions[result.value];

        this.findCourseByName();

        Swal.fire(
          'Curso seleccionado',
          'El curso '+inputOptions[result.value]+' ha sido seleccionado con exito',
          'success'
        )
      }
    });
  }

}
