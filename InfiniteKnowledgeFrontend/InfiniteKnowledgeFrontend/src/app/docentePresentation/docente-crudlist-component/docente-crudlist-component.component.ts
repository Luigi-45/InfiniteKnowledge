import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Docente } from 'src/app/entities/docente';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-docente-crudlist-component',
  templateUrl: './docente-crudlist-component.component.html',
  styleUrls: ['./docente-crudlist-component.component.css']
})
export class DocenteCRUDListComponentComponent implements OnInit{
  listaDocente:Docente[];

  constructor(private docenteGateway:DocenteGatewayService, private router:Router){}

  ngOnInit(): void {
    this.listTeacher();
  }

  private listTeacher(){
    this.docenteGateway.findAll().subscribe(data => {
      this.listaDocente = data;
    });
  }

  createTeacher(){
    this.router.navigate(['/docente/guardar']);
  }

  modifyTeacher(docenteId:number){
    this.router.navigate(['/docente/modificar'], { queryParams: { docenteId:docenteId } });
  }

  infoTeacher(docenteId:number){
    this.router.navigate(['/docente/info'], { queryParams: { docenteId:docenteId } });
  }

  deleteTeacher(docenteId:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas eliminar al Docente",
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
        this.docenteGateway.delete(docenteId).subscribe(data => {
          console.log(data);
          this.listTeacher();
          Swal.fire(
            'Docente eliminado',
            'El docente ha sido eliminado con exito',
            'success'
          )
        })
      }
    });
  }
}
