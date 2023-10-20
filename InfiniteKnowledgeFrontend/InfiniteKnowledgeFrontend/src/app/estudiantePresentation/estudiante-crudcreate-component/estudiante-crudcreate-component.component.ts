import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudiante } from 'src/app/entities/estudiante';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-estudiante-crudcreate-component',
  templateUrl: './estudiante-crudcreate-component.component.html',
  styleUrls: ['./estudiante-crudcreate-component.component.css']
})
export class EstudianteCRUDCreateComponentComponent implements OnInit{

  estudiante:Estudiante;
  options:string[] = ["Hombre","Mujer"];

  constructor(private estudianteGateway:EstudianteGatewayService, private router:Router){}

  ngOnInit(): void {
    this.estudiante = new Estudiante();
  }

  saveStudent(){
    this.estudianteGateway.save(this.estudiante).subscribe(data => {
      this.redirect();
    }, error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/estudiante']);
    Swal.fire('Estudiante registrado',`El estudiante ${this.estudiante.nombre} ha sido registrado satisfactoriamente`);
  }

  onSubmit(){
    this.saveStudent();
  }
}
