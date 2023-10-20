import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GradoSeccion } from 'src/app/entities/grado-seccion';
import { GradoSeccionGatewayService } from 'src/app/gateways/grado-seccion-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-grado-seccion-crudcreate',
  templateUrl: './grado-seccion-crudcreate.component.html',
  styleUrls: ['./grado-seccion-crudcreate.component.css']
})
export class GradoSeccionCRUDCreateComponent implements OnInit{
  gradoSeccion:GradoSeccion;
  options:string[] = ["A","B","C","D"];

  constructor(private gradoSeccionGateway:GradoSeccionGatewayService, private router:Router){}

  ngOnInit(): void {
    this.gradoSeccion = new GradoSeccion();
  }

  saveCourse(){
    this.gradoSeccionGateway.save(this.gradoSeccion).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/gradoSeccion']);
    Swal.fire('Grado y Sección registrado',`El grado y sección ${this.gradoSeccion.grado.toString()+this.gradoSeccion.seccion} ha sido registrado satisfactoriamente`);
  }

  onSubmit(){
    this.saveCourse();
  }
}
