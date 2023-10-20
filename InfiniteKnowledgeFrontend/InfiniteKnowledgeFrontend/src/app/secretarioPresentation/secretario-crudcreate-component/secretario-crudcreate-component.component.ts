import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Secretario } from 'src/app/entities/secretario';
import { SecretarioGatewayService } from 'src/app/gateways/secretario-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-secretario-crudcreate-component',
  templateUrl: './secretario-crudcreate-component.component.html',
  styleUrls: ['./secretario-crudcreate-component.component.css']
})
export class SecretarioCRUDCreateComponentComponent implements OnInit{

  secretario:Secretario;
  options:string[] = ["Hombre","Mujer"];

  constructor(private secretarioGateway:SecretarioGatewayService, private router:Router){}

  ngOnInit(): void {
    this.secretario = new Secretario();
  }

  saveSecretary(){
    this.secretarioGateway.save(this.secretario).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/secretario']);
    Swal.fire('Secretario registrado',`El secretario ${this.secretario.nombre} ha sido registrado satisfactoriamente`);
  }

  onSubmit(){
    this.saveSecretary();
  }
}
