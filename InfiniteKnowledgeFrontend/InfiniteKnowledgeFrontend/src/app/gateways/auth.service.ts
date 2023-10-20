import { Injectable } from '@angular/core';
import { UsuarioGatewayService } from './usuario-gateway.service';
import { Usuario } from '../entities/usuario';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn = false;

  constructor(private usuarioGateway:UsuarioGatewayService, private cookieService: CookieService, private router:Router) { }

  login(email: string, password: string): boolean{
    var usuario:Usuario = new Usuario();
    this.usuarioGateway.findByCorreoElectronico(email).subscribe(data => {
      usuario = data;
      this.cookieService.set('correo', usuario.correoElectronico);
      this.cookieService.set('contrasenia',password);
      this.cookieService.set('rol', usuario.rol.toString());
      this.cookieService.set('dni', usuario.dni);

      if(usuario){
        this.loggedIn = true;
        this.router.navigate(['/home']);
      }
      else{
        this.loggedIn = false;
      }
    });

    return this.loggedIn;
  } 

  logout() {
    this.cookieService.delete('correo');
    this.cookieService.delete('contrasenia');
    this.cookieService.delete('rol');
    this.cookieService.delete('dni');
    this.loggedIn = false;
  }

  isLoggedIn(): boolean {
    return this.loggedIn;
  }
}
