import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  nombreCompleto:string = '';

  constructor(private cookieService: CookieService, private estudianteGateway: EstudianteGatewayService) {}

  ngOnInit(): void {
    switch(this.cookieService.get('rol')){
      case '0':
        this.nombreCompleto = "Gestor de TI";
        break;
      case '3':
        this.estudianteGateway.findByDni(this.cookieService.get('dni')).subscribe(data => {
          this.nombreCompleto = "Estudiante - "+data.nombre + " " + data.apellido;
        });
        break;
    }
  }

}
