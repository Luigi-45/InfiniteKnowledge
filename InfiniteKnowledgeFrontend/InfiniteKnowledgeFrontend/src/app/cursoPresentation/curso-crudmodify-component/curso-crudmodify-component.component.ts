import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Curso } from 'src/app/entities/curso';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-curso-crudmodify-component',
  templateUrl: './curso-crudmodify-component.component.html',
  styleUrls: ['./curso-crudmodify-component.component.css']
})
export class CursoCRUDModifyComponentComponent implements OnInit{

  cursoId:number;
  curso:Curso;
  options:string[] = ["Ciencias","Humanidades"];

  constructor(private route:ActivatedRoute, private cursoGateway:CursoGatewayService, private router:Router){}

  ngOnInit(): void {
    this.cursoId = Number(this.route.snapshot.queryParamMap.get('cursoId'));
  
    this.curso = new Curso();
    this.cursoGateway.findById(this.cursoId).subscribe(data => {
      this.curso = data;
    });
  }

  updateCourse(){
    this.cursoGateway.update(this.curso).subscribe(data => {
      console.log(data);
      this.redirect();
    },error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/curso']);
    Swal.fire('Curso actualizado',`El curso ${this.curso.nombre} ha sido actualizado con éxito`,`success`);
  }

  onSubmit(){
    this.updateCourse();
  }

}
