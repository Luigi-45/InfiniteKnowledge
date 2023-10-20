import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Docente } from 'src/app/entities/docente';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';

@Component({
  selector: 'app-docente-crudinfo-component',
  templateUrl: './docente-crudinfo-component.component.html',
  styleUrls: ['./docente-crudinfo-component.component.css']
})
export class DocenteCRUDInfoComponentComponent implements OnInit{

  docenteId:number;
  docente:Docente;

  constructor(private route:ActivatedRoute, private docenteGateway:DocenteGatewayService){}

  ngOnInit(): void {

    this.docenteId = Number(this.route.snapshot.queryParamMap.get('docenteId'));

    this.docenteGateway.findById(this.docenteId).subscribe(data => {
      this.docente = data;
    });

  }

}
