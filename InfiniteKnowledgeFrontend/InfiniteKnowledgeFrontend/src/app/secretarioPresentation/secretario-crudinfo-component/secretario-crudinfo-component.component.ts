import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Secretario } from 'src/app/entities/secretario';
import { SecretarioGatewayService } from 'src/app/gateways/secretario-gateway.service';

@Component({
  selector: 'app-secretario-crudinfo-component',
  templateUrl: './secretario-crudinfo-component.component.html',
  styleUrls: ['./secretario-crudinfo-component.component.css']
})
export class SecretarioCRUDInfoComponentComponent implements OnInit{

  secretarioId:number;
  secretario:Secretario;

  constructor(private route:ActivatedRoute, private secretarioGateway:SecretarioGatewayService){}

  ngOnInit(): void {
    this.secretarioId = Number(this.route.snapshot.queryParamMap.get('secretarioId'));

    this.secretario = new Secretario();
    this.secretarioGateway.findById(this.secretarioId).subscribe(data => {
      this.secretario = data;
    });
  }

}
