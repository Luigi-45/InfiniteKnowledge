import { Component, OnInit } from '@angular/core';
import { EstudianteGatewayService } from '../../gateways/estudiante-gateway.service';
import { Estudiante } from 'src/app/entities/estudiante';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-estudiante-crudlist-component',
  templateUrl: './estudiante-crudlist-component.component.html',
  styleUrls: ['./estudiante-crudlist-component.component.css']
})
export class EstudianteCRUDListComponentComponent implements OnInit{
  listaEstudiante: Estudiante[];

  constructor(private estudianteGateway:EstudianteGatewayService, private router:Router){}

  ngOnInit(): void {
    this.findAll();
  }
  
  private findAll(){
    this.estudianteGateway.findAll().subscribe(data => {
      this.listaEstudiante = data;
    });
  }

  createStudent(){
    this.router.navigate(['/estudiante/guardar']);
  }

  modifyStudent(estudianteId:number){
    this.router.navigate(['/estudiante/modificar'], { queryParams: { estudianteId:estudianteId } });
  }

  infoStudent(estudianteId:number){
    this.router.navigate(['/estudiante/info'], { queryParams: { estudianteId:estudianteId } });
  }

  deleteStudent(estudianteId:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas eliminar al Estudiante",
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
        this.estudianteGateway.delete(estudianteId).subscribe(data => {
          console.log(data);
          this.findAll();
          Swal.fire(
            'Estudiante eliminado',
            'El estudiante ha sido eliminado con exito',
            'success'
          )
        })
      }
    });
  }
}
