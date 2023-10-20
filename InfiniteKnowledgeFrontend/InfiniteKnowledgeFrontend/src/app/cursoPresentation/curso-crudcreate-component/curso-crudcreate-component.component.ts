import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Curso } from 'src/app/entities/curso';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-curso-crudcreate-component',
  templateUrl: './curso-crudcreate-component.component.html',
  styleUrls: ['./curso-crudcreate-component.component.css']
})
export class CursoCRUDCreateComponentComponent implements OnInit{

  curso:Curso;
  options:string[] = ["Ciencias","Humanidades"];

  constructor(private cursoGateway:CursoGatewayService, private router:Router){}

  ngOnInit(): void {
    this.curso = new Curso();
  }

  saveCourse(){
    this.cursoGateway.save(this.curso).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/curso']);
    Swal.fire('Curso registrado',`El curso ${this.curso.nombre} ha sido registrado satisfactoriamente`);
  }

  onSubmit(){
    this.saveCourse();
  }

}
