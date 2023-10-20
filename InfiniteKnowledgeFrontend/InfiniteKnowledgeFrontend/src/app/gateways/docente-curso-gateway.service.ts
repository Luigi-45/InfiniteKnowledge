import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DocenteCurso } from '../entities/docente-curso';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class DocenteCursoGatewayService {
  private baseUrl="http://localhost:8083/api/docenteCurso";

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  findAll():Observable<DocenteCurso[]>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<DocenteCurso[]>(`${this.baseUrl}`, { headers });
  }

  findNames():Observable<Object[][]>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<Object[][]>(`${this.baseUrl}/findNames`,{ headers });
  }

  save(docenteCurso:DocenteCurso) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.post(`${this.baseUrl}/guardar`,docenteCurso,{ headers });
  }

  findById(docenteCursoId:number):Observable<DocenteCurso>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<DocenteCurso>(`${this.baseUrl}/findById?docenteCursoId=${docenteCursoId}`,{ headers });
  }

  findByDocenteIdAndCursoId(docenteId:number, cursoId:number):Observable<DocenteCurso>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<DocenteCurso>(`${this.baseUrl}/findByDocenteCurso?docenteId=${docenteId}&cursoId=${cursoId}`,{ headers });
  }

  update(docenteCurso:DocenteCurso) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.put(`${this.baseUrl}/actualizar`,docenteCurso,{ headers });
  }

  delete(docenteCursoId:number): Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.delete(`${this.baseUrl}/eliminar?docenteCursoId=${docenteCursoId}`,{ headers });
  }
}
