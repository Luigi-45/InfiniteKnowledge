import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegistroMatricula } from '../entities/registro-matricula';
import { Observable } from 'rxjs';
import { GradoSeccion } from '../entities/grado-seccion';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class RegistroMatriculaGatewayService {

  private baseUrl="http://localhost:8084/api/registroMatricula";

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  findAllByGradoSeccion(gradoSeccionId:number):Observable<RegistroMatricula[]>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<RegistroMatricula[]>(`${this.baseUrl}?gradoSeccionId=${gradoSeccionId}`, { headers });
  }

  save(registroMatricula:RegistroMatricula) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.post(`${this.baseUrl}/guardar`,registroMatricula, { headers });
  }

  findById(registroMatriculaId:number):Observable<RegistroMatricula>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<RegistroMatricula>(`${this.baseUrl}/findById?registroMatriculaId=${registroMatriculaId}`,{ headers });
  }

  update(registroMatricula:RegistroMatricula) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.put(`${this.baseUrl}/actualizar`,registroMatricula,{ headers });
  }

  delete(registroMatriculaId:number): Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.delete(`${this.baseUrl}/eliminar?registroMatriculaId=${registroMatriculaId}`,{ headers });
  }
}
