import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/entities/usuario';
import { UsuarioGatewayService } from 'src/app/gateways/usuario-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-usuario-crudcreate',
  templateUrl: './usuario-crudcreate.component.html',
  styleUrls: ['./usuario-crudcreate.component.css']
})
export class UsuarioCRUDCreateComponent implements OnInit{
  usuario:Usuario;
  options:string[] = ["Secretario","Docente","Estudiante"];
  selectedOption:string = "";

  constructor(private usuarioGateway:UsuarioGatewayService, private router:Router){}

  ngOnInit(): void {
    this.usuario = new Usuario();
  }

  saveUser(){
    this.changeRol();
    this.setPassword();

    this.usuarioGateway.save(this.usuario).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/perfil']);
    Swal.fire('Usuario registrado',`El usuario ${this.usuario.correoElectronico} ha sido registrado satisfactoriamente`);
  }

  onSubmit(){
    this.saveUser();
  }

  changeRol(){
    switch(this.selectedOption){
      case "Secretario":
        this.usuario.rol = 1;
        break;
      case "Docente":
        this.usuario.rol = 2;
        break;    
      case "Estudiante":
        this.usuario.rol = 3;
        break;
    }
  }

  setPassword(){
    this.usuario.contrasenia = this.usuario.dni;
  }
}
