import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Secretario } from 'src/app/entities/secretario';
import { SecretarioGatewayService } from 'src/app/gateways/secretario-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-secretario-crudmodify-component',
  templateUrl: './secretario-crudmodify-component.component.html',
  styleUrls: ['./secretario-crudmodify-component.component.css']
})
export class SecretarioCRUDModifyComponentComponent implements OnInit{

  secretarioId:number;
  secretario:Secretario;
  options:string[] = ["Hombre","Mujer"];

  constructor(private route:ActivatedRoute, private secretarioGateway:SecretarioGatewayService, private router:Router){}

  ngOnInit(): void {
    this.secretarioId = Number(this.route.snapshot.queryParamMap.get('secretarioId'));
  
    this.secretario = new Secretario();
    this.secretarioGateway.findById(this.secretarioId).subscribe(data => {
      this.secretario = data;
    });
  }

  updateSecretary(){
    this.secretarioGateway.update(this.secretario).subscribe(data => {
      console.log(data);
      this.redirect();
    },error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/secretario']);
    Swal.fire('Secretario actualizado',`El secretario ${this.secretario.nombre} ha sido actualizado con éxito`,`success`);
  }

  onSubmit(){
    this.updateSecretary();
  }
}
