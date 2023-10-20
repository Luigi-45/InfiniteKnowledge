import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Curso } from 'src/app/entities/curso';
import { CursoGatewayService } from 'src/app/gateways/curso-gateway.service';

@Component({
  selector: 'app-curso-crudinfo-component',
  templateUrl: './curso-crudinfo-component.component.html',
  styleUrls: ['./curso-crudinfo-component.component.css']
})
export class CursoCRUDInfoComponentComponent implements OnInit{

  cursoId:number;
  curso:Curso;

  constructor(private route:ActivatedRoute, private cursoGateway:CursoGatewayService){}

  ngOnInit(): void {
    this.cursoId = Number(this.route.snapshot.queryParamMap.get('cursoId'));

    this.curso = new Curso();
    this.cursoGateway.findById(this.cursoId).subscribe(data => {
      this.curso = data;
    });
  }

}
