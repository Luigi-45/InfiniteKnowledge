import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Docente } from 'src/app/entities/docente';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-docente-crudmodify-component',
  templateUrl: './docente-crudmodify-component.component.html',
  styleUrls: ['./docente-crudmodify-component.component.css']
})
export class DocenteCRUDModifyComponentComponent implements OnInit{

  docenteId:number;
  docente:Docente;

  genders:string[] = ["Hombre","Mujer"];
  options:string[] = ["Ciencias","Humanidades"];

  constructor(private route:ActivatedRoute, private docenteGateway:DocenteGatewayService, private router:Router){}

  ngOnInit(): void {
    this.docenteId = Number(this.route.snapshot.queryParamMap.get('docenteId'));
  
    this.docente = new Docente();
    this.docenteGateway.findById(this.docenteId).subscribe(data => {
      this.docente = data;
    });
  }

  updateTeacher(){
    this.docenteGateway.update(this.docente).subscribe(data => {
      console.log(data);
      this.redirect();
    },error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/docente']);
    Swal.fire('Docente actualizado',`El docente ${this.docente.nombre} ha sido actualizado con éxito`,`success`);
  }

  onSubmit(){
    this.updateTeacher();
  }

}
