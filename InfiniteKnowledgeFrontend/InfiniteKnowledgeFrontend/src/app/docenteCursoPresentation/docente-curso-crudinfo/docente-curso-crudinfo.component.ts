import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Curso } from 'src/app/entities/curso';
import { Docente } from 'src/app/entities/docente';
import { DocenteCurso } from 'src/app/entities/docente-curso';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';
import { DocenteCursoGatewayService } from 'src/app/gateways/docente-curso-gateway.service';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';

@Component({
  selector: 'app-docente-curso-crudinfo',
  templateUrl: './docente-curso-crudinfo.component.html',
  styleUrls: ['./docente-curso-crudinfo.component.css']
})
export class DocenteCursoCRUDInfoComponent implements OnInit{

  docenteCurso:DocenteCurso;
  docenteCursoId:number;
  
  docente:Docente;
  nombreDocente:string = "";

  curso:Curso;
  
  constructor(private route:ActivatedRoute, private docenteCursoGateway:DocenteCursoGatewayService, 
    private cursoGateway:CursoGatewayService, private docenteGateway:DocenteGatewayService){}

  ngOnInit(): void {
    this.docenteCursoId = Number(this.route.snapshot.queryParamMap.get('docenteCursoId'));

    this.docenteCurso = new DocenteCurso();
    this.docenteCursoGateway.findById(this.docenteCursoId).subscribe(data => {
      this.docenteCurso = data;

      this.docente = new Docente();
      this.docenteGateway.findById(this.docenteCurso.docenteId).subscribe(data => {
        this.docente = data;
        this.nombreDocente = this.docente.nombre + " " + this.docente.apellido;
      });

      this.curso = new Curso();
      this.cursoGateway.findById(this.docenteCurso.cursoId).subscribe(data => {
        this.curso = data;
      });
    });
  }

}
