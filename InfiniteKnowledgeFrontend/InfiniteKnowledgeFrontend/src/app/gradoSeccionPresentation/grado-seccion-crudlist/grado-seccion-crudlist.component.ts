import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GradoSeccion } from 'src/app/entities/grado-seccion';
import { GradoSeccionGatewayService } from 'src/app/gateways/grado-seccion-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-grado-seccion-crudlist',
  templateUrl: './grado-seccion-crudlist.component.html',
  styleUrls: ['./grado-seccion-crudlist.component.css']
})
export class GradoSeccionCRUDListComponent implements OnInit{
  listaGradosSecciones: GradoSeccion[];

  constructor(private gradoSeccionGateway:GradoSeccionGatewayService, private router:Router){}

  ngOnInit(): void {
    this.findAll();
  }
  
  private findAll(){
    this.gradoSeccionGateway.findAll().subscribe(data => {
      this.listaGradosSecciones = data;
    });
  }

  createGradoSeccion(){
    this.router.navigate(['/gradoSeccion/guardar']);
  }

  modifyGradoSeccion(gradoSeccionId:number){
    this.router.navigate(['/gradoSeccion/modificar'], { queryParams: { gradoSeccionId:gradoSeccionId } });
  }

  infoGradoSeccion(gradoSeccionId:number){
    this.router.navigate(['/gradoSeccion/info'], { queryParams: { gradoSeccionId:gradoSeccionId } });
  }

  deleteGradoSeccion(gradoSeccionId:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas eliminar al Grado y Sección",
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
        this.gradoSeccionGateway.delete(gradoSeccionId).subscribe(data => {
          console.log(data);
          this.findAll();
          Swal.fire(
            'Grado y sección eliminado',
            'El grado y sección ha sido eliminado con exito',
            'success'
          )
        })
      }
    });
  }
}
