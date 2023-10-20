import { Component } from '@angular/core';
import { AuthService } from 'src/app/gateways/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  correoElectronico:string;
  contrasenia:string;

  constructor(private authService:AuthService){}

  onSubmit() {
    this.authService.login(this.correoElectronico, this.contrasenia);
  }
}
