import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GradoSeccion } from '../entities/grado-seccion';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class GradoSeccionGatewayService {
  private baseUrl="http://localhost:8083/api/gradoSeccion";

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  findAll():Observable<GradoSeccion[]>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<GradoSeccion[]>(`${this.baseUrl}`, { headers });
  }

  save(gradoSeccion:GradoSeccion) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.post(`${this.baseUrl}/guardar`,gradoSeccion,{ headers });
  }

  findById(gradoSeccionId:number):Observable<GradoSeccion>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<GradoSeccion>(`${this.baseUrl}/findById?gradoSeccionId=${gradoSeccionId}`,{ headers });
  }

  update(gradoSeccion:GradoSeccion) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.put(`${this.baseUrl}/actualizar`,gradoSeccion,{ headers });
  }

  delete(gradoSeccionId:number): Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.delete(`${this.baseUrl}/eliminar?gradoSeccionId=${gradoSeccionId}`,{ headers });
  }
}
