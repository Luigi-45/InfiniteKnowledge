import { Injectable } from '@angular/core';
import { Secretario } from '../entities/secretario';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class SecretarioGatewayService {

  private baseUrl="http://localhost:8082/api/secretario";

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  findAll():Observable<Secretario[]>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<Secretario[]>(`${this.baseUrl}`,{ headers });
  }

  save(secretario:Secretario) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.post(`${this.baseUrl}/guardar`,secretario,{ headers });
  }

  findById(secretarioId:number):Observable<Secretario>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<Secretario>(`${this.baseUrl}/findById?secretarioId=${secretarioId}`,{ headers });
  }

  findByDni(dni:string):Observable<Secretario>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<Secretario>(`${this.baseUrl}/findByDni?dni=${dni}`, { headers });
  }

  update(secretario:Secretario) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.put(`${this.baseUrl}/actualizar`,secretario,{ headers });
  }

  delete(secretarioId:number): Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.delete(`${this.baseUrl}/eliminar?secretarioId=${secretarioId}`,{ headers });
  }
}
