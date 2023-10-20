import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from 'src/app/entities/usuario';
import { UsuarioGatewayService } from 'src/app/gateways/usuario-gateway.service';

@Component({
  selector: 'app-usuario-crudinfo',
  templateUrl: './usuario-crudinfo.component.html',
  styleUrls: ['./usuario-crudinfo.component.css']
})
export class UsuarioCRUDInfoComponent implements OnInit{

  usuarioId:number;
  usuario:Usuario;
  selectedOption:string = "";

  constructor(private route:ActivatedRoute, private usuarioGateway:UsuarioGatewayService){}

  ngOnInit(): void {
    this.usuarioId = Number(this.route.snapshot.queryParamMap.get('usuarioId'));

    this.usuario = new Usuario();
    this.usuarioGateway.findById(this.usuarioId).subscribe(data => {
      this.usuario = data;
      this.changeRol();
    });

  }

  changeRol(){
    switch(this.usuario.rol){
      case 1:
        this.selectedOption = "Secretario";
        break;
      case 2:
        this.selectedOption = "Docente";
        break;    
      case 3:
        this.selectedOption = "Estudiante";
        break;
    }
  }
}
