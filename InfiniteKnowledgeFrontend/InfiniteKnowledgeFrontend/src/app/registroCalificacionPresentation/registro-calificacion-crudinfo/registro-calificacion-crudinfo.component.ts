import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RegistroCalificacionForList } from 'src/app/entities/registro-calificacion-for-list';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';
import { DocenteCursoGatewayService } from 'src/app/gateways/docente-curso-gateway.service';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';
import { RegistroCalificacionGatewayService } from 'src/app/gateways/registro-calificacion-gateway.service';

@Component({
  selector: 'app-registro-calificacion-crudinfo',
  templateUrl: './registro-calificacion-crudinfo.component.html',
  styleUrls: ['./registro-calificacion-crudinfo.component.css']
})
export class RegistroCalificacionCRUDInfoComponent implements OnInit{
  registroCalificacion:RegistroCalificacionForList;
  registroCalificacionId:number;
  promedio:number;
  
  constructor(private route:ActivatedRoute, private estudianteGateway:EstudianteGatewayService, private docenteCursoGateway:DocenteCursoGatewayService,
    private docenteGateway:DocenteGatewayService, private cursoGateway:CursoGatewayService,private registroCalificacionGateway:RegistroCalificacionGatewayService){}

  ngOnInit(): void {
    this.registroCalificacionId = Number(this.route.snapshot.queryParamMap.get('registroCalificacionId'));

    this.registroCalificacion = new RegistroCalificacionForList();
    this.registroCalificacionGateway.findById(this.registroCalificacionId).subscribe(data => {
      this.registroCalificacion.registroCalifacionId = data.registroCalificacionId;
      this.registroCalificacion.calificacion1 = data.calificacion1;
      this.registroCalificacion.calificacion2 = data.calificacion2;
      this.registroCalificacion.calificacion3 = data.calificacion3;
      this.registroCalificacion.calificacion4 = data.calificacion4
      this.registroCalificacion.bimestre = data.bimestre;

      this.promedio = (this.registroCalificacion.calificacion1+this.registroCalificacion.calificacion2+this.registroCalificacion.calificacion3+this.registroCalificacion.calificacion4)/4;

      this.estudianteGateway.findById(data.estudianteId).subscribe(data2 => {
        this.registroCalificacion.estudiante = data2.nombre + " " + data2.apellido;

        this.docenteCursoGateway.findById(data.docenteCursoId).subscribe(data3 => {
          this.docenteGateway.findById(data3.docenteId).subscribe(data4 => {
            this.registroCalificacion.docenteCurso = data4.nombre + " " + data4.apellido + " - ";

            this.cursoGateway.findById(data3.cursoId).subscribe(data5 => {
              this.registroCalificacion.docenteCurso += data5.nombre;

              
            });
            
          });

        });
      });
    });
  }
}
