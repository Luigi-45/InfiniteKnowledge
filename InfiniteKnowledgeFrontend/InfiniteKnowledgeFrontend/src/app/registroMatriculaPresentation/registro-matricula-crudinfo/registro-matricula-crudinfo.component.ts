import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Estudiante } from 'src/app/entities/estudiante';
import { GradoSeccion } from 'src/app/entities/grado-seccion';
import { RegistroMatricula } from 'src/app/entities/registro-matricula';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';
import { GradoSeccionGatewayService } from 'src/app/gateways/grado-seccion-gateway.service';
import { RegistroMatriculaGatewayService } from 'src/app/gateways/registro-matricula-gateway.service';

@Component({
  selector: 'app-registro-matricula-crudinfo',
  templateUrl: './registro-matricula-crudinfo.component.html',
  styleUrls: ['./registro-matricula-crudinfo.component.css']
})
export class RegistroMatriculaCRUDInfoComponent implements OnInit{
  registroMatricula:RegistroMatricula;
  registroMatriculaId:number;
  
  estudiante:Estudiante;
  nombreEstudiante:string = "";

  gradoSeccion:GradoSeccion;
  gradoYSeccion:string = "";
  
  constructor(private route:ActivatedRoute, private estudianteGateway:EstudianteGatewayService, 
    private gradoSeccionGateway:GradoSeccionGatewayService, private registroMatriculaGateway:RegistroMatriculaGatewayService){}

  ngOnInit(): void {
    this.registroMatriculaId = Number(this.route.snapshot.queryParamMap.get('registroMatriculaId'));

    this.registroMatricula = new RegistroMatricula();
    this.registroMatriculaGateway.findById(this.registroMatriculaId).subscribe(data => {
      this.registroMatricula = data;

      this.estudiante = new Estudiante();
      this.estudianteGateway.findById(this.registroMatricula.estudianteId).subscribe(data => {
        this.estudiante = data;
        this.nombreEstudiante = this.estudiante.nombre + " " + this.estudiante.apellido;
      });

      this.gradoSeccion = new GradoSeccion();
      this.gradoSeccionGateway.findById(this.registroMatricula.gradoSeccionId).subscribe(data => {
        this.gradoSeccion = data;
        this.gradoYSeccion = this.gradoSeccion.grado+this.gradoSeccion.seccion;
      });
    });
  }
}
