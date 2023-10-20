import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/entities/usuario';
import { UsuarioGatewayService } from 'src/app/gateways/usuario-gateway.service';

@Component({
  selector: 'app-usuario-crudlist',
  templateUrl: './usuario-crudlist.component.html',
  styleUrls: ['./usuario-crudlist.component.css']
})
export class UsuarioCRUDListComponent implements OnInit{
  listaPerfiles:Usuario[];
  listaRoles:Map<number,string> = new Map();

  constructor(private usuarioGateway:UsuarioGatewayService, private router:Router){}

  ngOnInit(): void {
    this.listUser();
  }

  private listUser(){
    this.usuarioGateway.findAll().subscribe(data => {
      this.listaPerfiles = data;
      this.setRoles();
    });
    
  }

  createProfile(){
    this.router.navigate(['/perfil/guardar']);
  }

  infoUser(usuarioId:number){
    this.router.navigate(['/perfil/info'], { queryParams: { usuarioId:usuarioId } });
  }

  setRoles(){
    this.listaPerfiles.forEach(perfil => {
      switch(perfil.rol){
        case 1:
          this.listaRoles.set(perfil.usuarioId,"Secretario");
          break;
        case 2:
          this.listaRoles.set(perfil.usuarioId,"Docente");
          break;
        case 3:
          this.listaRoles.set(perfil.usuarioId,"Estudiante");
          break;
      }
    });
  }

}
