import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegistroCalificacion } from '../entities/registro-calificacion';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class RegistroCalificacionGatewayService {
  private baseUrl="http://localhost:8084/api/registroCalificacion";

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  findAllByDocenteCursoBimestre(docenteCursoId:number,bimestre:number):Observable<RegistroCalificacion[]>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<RegistroCalificacion[]>(`${this.baseUrl}?docenteCursoId=${docenteCursoId}&bimestre=${bimestre}`, { headers });
  }

  save(registrosCalificacion:RegistroCalificacion[]) : Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.post(`${this.baseUrl}/guardar`,registrosCalificacion, { headers });
  }

  generatePdf(registrosCalificacion:Object[][]){
    const url = `${this.baseUrl}/pdf`; 
  
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/pdf',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });
  
    this.httpClient.post(url, registrosCalificacion, { headers: headers, responseType: 'blob' })
      .subscribe((response: Blob) => {
        const fileURL = URL.createObjectURL(response);
  
        const link = document.createElement('a');
        link.href = fileURL;
        link.download = 'ReporteCalificaciones.pdf'; 
        link.target = '_blank';
  
        link.click();
      }, (error) => {
        console.error('Error al descargar el PDF', error);
      });
  }

  generateExcel(registrosCalificacion:Object[][]){
    const headers = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia')) 
    });
    this.httpClient.post(`${this.baseUrl}/excel`, registrosCalificacion, { headers: headers, responseType: 'blob' })
    .subscribe((response: Blob) => {
      const fileURL = URL.createObjectURL(response);

      const link = document.createElement('a');
      link.href = fileURL;
      link.download = 'ReporteCalificaciones.xlsx'; 
      link.target = '_blank';

      link.click();
    }, (error) => {
      console.error('Error al descargar el archivo Excel', error);
    });
  }

  findById(registroCalificacionId:number):Observable<RegistroCalificacion>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.get<RegistroCalificacion>(`${this.baseUrl}/findById?registroCalificacionId=${registroCalificacionId}`, { headers });
  }

  delete(registroCalificacionId:number): Observable<Object>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa(this.cookieService.get('correo') + ':' + this.cookieService.get('contrasenia'))
    });

    return this.httpClient.delete(`${this.baseUrl}/eliminar?registroCalificacionId=${registroCalificacionId}`, { headers });
  }
}
