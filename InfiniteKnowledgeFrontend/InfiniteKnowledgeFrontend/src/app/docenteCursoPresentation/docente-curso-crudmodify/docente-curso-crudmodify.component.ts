import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Curso } from 'src/app/entities/curso';
import { Docente } from 'src/app/entities/docente';
import { DocenteCurso } from 'src/app/entities/docente-curso';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';
import { DocenteCursoGatewayService } from 'src/app/gateways/docente-curso-gateway.service';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-docente-curso-crudmodify',
  templateUrl: './docente-curso-crudmodify.component.html',
  styleUrls: ['./docente-curso-crudmodify.component.css']
})
export class DocenteCursoCRUDModifyComponent implements OnInit{
  docenteCursoId:number;
  docenteCurso:DocenteCurso;

  docente:Docente;
  docenteId:number;
  listaDocentes:Docente[];
  docenteSeleccionado:string;

  curso:Curso;
  cursoId:number;
  listaCursos:Curso[];
  cursoSeleccionado:string;

  
  constructor(private route:ActivatedRoute, private docenteGateway:DocenteGatewayService, private cursoGateway:CursoGatewayService, 
    private docenteCursoGateway:DocenteCursoGatewayService, private router:Router){}

  ngOnInit(): void {
    this.docenteCursoId = Number(this.route.snapshot.queryParamMap.get('docenteCursoId'));
  
    this.docenteCurso = new DocenteCurso();
    this.docenteCursoGateway.findById(this.docenteCursoId).subscribe(data => {
      this.docenteCurso = data;

      this.docenteGateway.findById(this.docenteCurso.docenteId).subscribe(data => {
        this.docente = data;
        this.docenteSeleccionado = this.docente.nombre + " " + this.docente.apellido;
      });
  
      this.cursoGateway.findById(this.docenteCurso.cursoId).subscribe(data => {
        this.curso = data;
        this.cursoSeleccionado = this.curso.nombre;
      });
  
      this.docenteGateway.findAll().subscribe(data => {
        this.listaDocentes = data;
      })
  
      this.cursoGateway.findAll().subscribe(data => {
        this.listaCursos = data;
      })
    });


  }

  updateAsignation(){
    this.findTeacherByName();
    this.findCourseByName();

    this.docenteCurso.docenteId = this.docenteId;
    this.docenteCurso.cursoId = this.cursoId;
    
    this.docenteCursoGateway.update(this.docenteCurso).subscribe(data => {
      console.log(data);
      this.redirect();
    },error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/docenteCurso']);
    Swal.fire('Asignación docente-curso actualizado',`La asignación docente-curso ha sido actualizada con éxito`,`success`);
  }

  onSubmit(){
    
    this.updateAsignation();
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
