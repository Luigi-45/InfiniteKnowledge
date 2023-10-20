import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Curso } from 'src/app/entities/curso';
import { Docente } from 'src/app/entities/docente';
import { DocenteCurso } from 'src/app/entities/docente-curso';
import { DocenteCursoForList } from 'src/app/entities/docente-curso-for-list';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';
import { DocenteCursoGatewayService } from 'src/app/gateways/docente-curso-gateway.service';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-docente-curso-crudlist',
  templateUrl: './docente-curso-crudlist.component.html',
  styleUrls: ['./docente-curso-crudlist.component.css']
})
export class DocenteCursoCRUDListComponent implements OnInit{
  asignacionesDocenteCurso: DocenteCurso[];
  docenteCursos:DocenteCursoForList[] = [];
  docente: Docente;
  curso: Curso;
  

  constructor(private docenteCursoGateway:DocenteCursoGatewayService, private docenteGateway: DocenteGatewayService, 
    private cursoGateway:CursoGatewayService, private router:Router){}

  ngOnInit(): void {
    this.findAll();
  }
  
  private findAll(){
    this.docenteCursoGateway.findAll().subscribe(data => {
      this.asignacionesDocenteCurso = data;

      this.asignacionesDocenteCurso.forEach((dc) => {

        var docenteCursoForList = new DocenteCursoForList();
        docenteCursoForList.docenteCursoId = dc.docenteCursoId;

        this.docenteGateway.findById(dc.docenteId).subscribe(data => {
          this.docente = data;
          docenteCursoForList.docenteNombre = this.docente.nombre+" "+this.docente.apellido;
        });
  
        this.cursoGateway.findById(dc.cursoId).subscribe(data => {
          this.curso = data;
          docenteCursoForList.cursoNombre = this.curso.nombre;
        })
        
        this.docenteCursos.push(docenteCursoForList);
      });
    });
  }

  createDocenteCurso(){
    this.router.navigate(['/docenteCurso/guardar']);
  }

  modifyAsignation(docenteCursoId:number){
    this.router.navigate(['/docenteCurso/modificar'], { queryParams: { docenteCursoId:docenteCursoId } });
  }

  infoAsignation(docenteCursoId:number){
    this.router.navigate(['/docenteCurso/info'], { queryParams: { docenteCursoId:docenteCursoId } });
  }

  deleteAsignation(docenteCursoId:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas eliminar la asignación",
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
        this.docenteCursoGateway.delete(docenteCursoId).subscribe(data => {
          console.log(data);
          this.findAll();
          Swal.fire(
            'Asignación eliminada',
            'La asignación docente-curso ha sido eliminada con exito',
            'success'
          )
        })
      }
    });
  }
}