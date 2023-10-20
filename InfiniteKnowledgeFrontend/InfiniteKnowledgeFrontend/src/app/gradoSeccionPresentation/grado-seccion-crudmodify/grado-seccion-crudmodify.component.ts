import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GradoSeccion } from 'src/app/entities/grado-seccion';
import { GradoSeccionGatewayService } from 'src/app/gateways/grado-seccion-gateway.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-grado-seccion-crudmodify',
  templateUrl: './grado-seccion-crudmodify.component.html',
  styleUrls: ['./grado-seccion-crudmodify.component.css']
})
export class GradoSeccionCRUDModifyComponent {
  gradoSeccionId:number;
  gradoSeccion:GradoSeccion;
  options:string[] = ["A","B","C","D"];

  constructor(private route:ActivatedRoute, private gradoSeccionGateway:GradoSeccionGatewayService, private router:Router){}

  ngOnInit(): void {
    this.gradoSeccionId = Number(this.route.snapshot.queryParamMap.get('gradoSeccionId'));
  
    this.gradoSeccion = new GradoSeccion();
    this.gradoSeccionGateway.findById(this.gradoSeccionId).subscribe(data => {
      this.gradoSeccion = data;
    });
  }

  updateGradoSeccion(){
    this.gradoSeccionGateway.update(this.gradoSeccion).subscribe(data => {
      console.log(data);
      this.redirect();
    },error => console.log(error));
  }

  redirect(){
    this.router.navigate(['/gradoSeccion']);
    Swal.fire('Grado y sección actualizado',`El grado y sección ${this.gradoSeccion.grado.toString()+this.gradoSeccion.seccion} ha sido actualizado con éxito`,`success`);
  }

  onSubmit(){
    this.updateGradoSeccion();
  }
}
