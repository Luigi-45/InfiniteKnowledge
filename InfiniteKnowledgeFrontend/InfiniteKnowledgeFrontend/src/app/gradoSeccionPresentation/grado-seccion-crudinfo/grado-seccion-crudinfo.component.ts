import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GradoSeccion } from 'src/app/entities/grado-seccion';
import { GradoSeccionGatewayService } from 'src/app/gateways/grado-seccion-gateway.service';

@Component({
  selector: 'app-grado-seccion-crudinfo',
  templateUrl: './grado-seccion-crudinfo.component.html',
  styleUrls: ['./grado-seccion-crudinfo.component.css']
})
export class GradoSeccionCRUDInfoComponent implements OnInit{

  gradoSeccionId:number;
  gradoSeccion:GradoSeccion;

  constructor(private route:ActivatedRoute, private gradoSeccionGateway:GradoSeccionGatewayService){}

  ngOnInit(): void {
    this.gradoSeccionId = Number(this.route.snapshot.queryParamMap.get('gradoSeccionId'));

    this.gradoSeccion = new GradoSeccion();
    this.gradoSeccionGateway.findById(this.gradoSeccionId).subscribe(data => {
      this.gradoSeccion = data;
    });
  }
}
