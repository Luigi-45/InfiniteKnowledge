import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router,  } from '@angular/router';
import { Estudiante } from 'src/app/entities/estudiante';
import { EstudianteGatewayService } from 'src/app/gateways/estudiante-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-estudiante-crudmodify-component',
  templateUrl: './estudiante-crudmodify-component.component.html',
  styleUrls: ['./estudiante-crudmodify-component.component.css']
})
export class EstudianteCRUDModifyComponentComponent implements OnInit{

  estudianteId:number;
  estudiante:Estudiante;
  options:string[] = ["Hombre","Mujer"];

  constructor(private route:ActivatedRoute, private estudianteGateway:EstudianteGatewayService, private router:Router){}

  ngOnInit(): void {
    this.estudianteId = Number(this.route.snapshot.queryParamMap.get('estudianteId'));
  
    this.estudiante = new Estudiante();
    this.estudianteGateway.findById(this.estudianteId).subscribe(data => {
      this.estudiante = data;
    });
  }

  updateStudent(){
    this.estudianteGateway.update(this.estudiante).subscribe(data => {
      console.log(data);
      this.redirect();
    },error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/estudiante']);
    Swal.fire('Estudiante actualizado',`El estudiante ${this.estudiante.nombre} ha sido actualizado con éxito`,`success`);
  }

  onSubmit(){
    this.updateStudent();
  }

}
