import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Secretario } from 'src/app/entities/secretario';
import { SecretarioGatewayService } from 'src/app/gateways/secretario-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-secretario-crudlist-component',
  templateUrl: './secretario-crudlist-component.component.html',
  styleUrls: ['./secretario-crudlist-component.component.css']
})
export class SecretarioCRUDListComponentComponent implements OnInit{

  listaSecretario:Secretario[];

  constructor(private secretarioGateway:SecretarioGatewayService, private router:Router){}

  ngOnInit(): void {
    this.listSecretary();
  }

  private listSecretary(){
    this.secretarioGateway.findAll().subscribe(data => {
      this.listaSecretario = data;
    });
  }

  createSecretary(){
    this.router.navigate(['/secretario/guardar'])
  }

  modifySecretary(secretarioId:number){
    this.router.navigate(['/secretario/modificar'], { queryParams: { secretarioId:secretarioId } });
  }

  infoSecretary(secretarioId:number){
    this.router.navigate(['/secretario/info'], { queryParams: { secretarioId:secretarioId } });
  }

  deleteSecretary(secretarioId:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Confirma si deseas eliminar al Secretario",
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
        this.secretarioGateway.delete(secretarioId).subscribe(data => {
          console.log(data);
          this.listSecretary();
          Swal.fire(
            'Secretario eliminado',
            'El secretario ha sido eliminado con exito',
            'success'
          )
        })
      }
    });
  }

}
