import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Curso } from 'src/app/entities/curso';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-curso-crudlist-component',
  templateUrl: './curso-crudlist-component.component.html',
  styleUrls: ['./curso-crudlist-component.component.css']
})
export class CursoCRUDListComponentComponent implements OnInit{
  listaCurso: Curso[];

  constructor(private cursoGateway:CursoGatewayService, private router:Router){}

  ngOnInit(): void {
    this.findAll();
  }
  
  private findAll(){
    this.cursoGateway.findAll().subscribe(data => {
      this.listaCurso = data;
    });
  }

  createCourse(){
    this.router.navigate(['/curso/guardar'])
  }

  modifyCourse(cursoId:number){
    this.router.navigate(['/curso/modificar'], { queryParams: { cursoId:cursoId } });
  }

  infoCourse(cursoId:number){
    this.router.navigate(['/curso/info'], { queryParams: { cursoId:cursoId } });
  }

  deleteCourse(cursoId:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas eliminar al Curso",
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
        this.cursoGateway.delete(cursoId).subscribe(data => {
          console.log(data);
          this.findAll();
          Swal.fire(
            'Curso eliminado',
            'El curso ha sido eliminado con exito',
            'success'
          )
        })
      }
    });
  }
}
