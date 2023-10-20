import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Estudiante } from 'src/app/entities/estudiante';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';

@Component({
  selector: 'app-estudiante-crudinfo-component',
  templateUrl: './estudiante-crudinfo-component.component.html',
  styleUrls: ['./estudiante-crudinfo-component.component.css']
})
export class EstudianteCRUDInfoComponentComponent implements OnInit{

  estudianteId:number;
  estudiante:Estudiante;

  constructor(private route:ActivatedRoute, private estudianteGateway:EstudianteGatewayService){}

  ngOnInit(): void {
    this.estudianteId = Number(this.route.snapshot.queryParamMap.get('estudianteId'));

    this.estudiante = new Estudiante();
    this.estudianteGateway.findById(this.estudianteId).subscribe(data => {
      this.estudiante = data;
    });
  }

}
