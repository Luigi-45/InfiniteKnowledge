import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Docente } from 'src/app/entities/docente';
import { DocenteGatewayService } from 'src/app/gateways/docente-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-docente-crudcreate-component',
  templateUrl: './docente-crudcreate-component.component.html',
  styleUrls: ['./docente-crudcreate-component.component.css']
})
export class DocenteCRUDCreateComponentComponent implements OnInit{

  docente:Docente;

  genders:string[] = ["Hombre","Mujer"];
  options:string[] = ["Ciencias","Humanidades"];

  constructor(private docenteGateway:DocenteGatewayService, private router:Router){}

  ngOnInit(): void {
    this.docente = new Docente();
  }

  saveTeacher(){
    this.docenteGateway.save(this.docente).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/docente']);
    Swal.fire('Docente registrado',`El docente ${this.docente.nombre} ha sido registrado satisfactoriamente`);
  }

  onSubmit(){
    this.saveTeacher();
  }

}
