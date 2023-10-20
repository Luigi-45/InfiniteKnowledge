import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../entities/usuario';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioGatewayService {

  private baseUrl="http://localhost:8082/api/usuario";
  private baseUrlForAll="http://localhost:8082/api/usuarioForAll";

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  findByCorreoElectronico(correoElectronico:string):Observable<Usuario>{
    return this.httpClient.get<Usuario>(`${this.baseUrlForAll}/findByCorreoElectronico?correoElectronico=${correoElectronico}`);
  }

  findAll():Observable<Usuario[]>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<Usuario[]>(`${this.baseUrl}`, { headers });
  }

  save(usuario:Usuario) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.post(`${this.baseUrl}/guardar`,usuario, { headers });
  }

  findByDni(dni:string):Observable<Usuario>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<Usuario>(`${this.baseUrl}/findByDni?dni=${dni}`,{ headers });
  }

  findById(usuarioId:number):Observable<Usuario>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<Usuario>(`${this.baseUrl}/findById?usuarioId=${usuarioId}`,{ headers });
  }

  update(usuario:Usuario) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.put(`${this.baseUrl}/actualizar`,usuario,{ headers });
  }

  delete(usuarioId:number): Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.delete(`${this.baseUrl}/eliminar?usuarioId=${usuarioId}`,{ headers });
  }
}
