import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EstudianteCRUDListComponentComponent } from './estudiantePresentation/estudiante-crudlist-component/estudiante-crudlist-component.component';
import { EstudianteCRUDCreateComponentComponent } from './estudiantePresentation/estudiante-crudcreate-component/estudiante-crudcreate-component.component';
import { EstudianteCRUDModifyComponentComponent } from './estudiantePresentation/estudiante-crudmodify-component/estudiante-crudmodify-component.component';
import { EstudianteCRUDInfoComponentComponent } from './estudiantePresentation/estudiante-crudinfo-component/estudiante-crudinfo-component.component';
import { DocenteCRUDListComponentComponent } from './docentePresentation/docente-crudlist-component/docente-crudlist-component.component';
import { DocenteCRUDCreateComponentComponent } from './docentePresentation/docente-crudcreate-component/docente-crudcreate-component.component';
import { DocenteCRUDModifyComponentComponent } from './docentePresentation/docente-crudmodify-component/docente-crudmodify-component.component';
import { DocenteCRUDInfoComponentComponent } from './docentePresentation/docente-crudinfo-component/docente-crudinfo-component.component';
import { SecretarioCRUDListComponentComponent } from './secretarioPresentation/secretario-crudlist-component/secretario-crudlist-component.component';
import { SecretarioCRUDCreateComponentComponent } from './secretarioPresentation/secretario-crudcreate-component/secretario-crudcreate-component.component';
import { SecretarioCRUDModifyComponentComponent } from './secretarioPresentation/secretario-crudmodify-component/secretario-crudmodify-component.component';
import { SecretarioCRUDInfoComponentComponent } from './secretarioPresentation/secretario-crudinfo-component/secretario-crudinfo-component.component';
import { CursoCRUDListComponentComponent } from './cursoPresentation/curso-crudlist-component/curso-crudlist-component.component';
import { CursoCRUDCreateComponentComponent } from './cursoPresentation/curso-crudcreate-component/curso-crudcreate-component.component';
import { CursoCRUDModifyComponentComponent } from './cursoPresentation/curso-crudmodify-component/curso-crudmodify-component.component';
import { CursoCRUDInfoComponentComponent } from './cursoPresentation/curso-crudinfo-component/curso-crudinfo-component.component';
import { UsuarioCRUDListComponent } from './usuarioPresentation/usuario-crudlist/usuario-crudlist.component';
import { UsuarioCRUDCreateComponent } from './usuarioPresentation/usuario-crudcreate/usuario-crudcreate.component';
import { UsuarioCRUDInfoComponent } from './usuarioPresentation/usuario-crudinfo/usuario-crudinfo.component';
import { GradoSeccionCRUDListComponent } from './gradoSeccionPresentation/grado-seccion-crudlist/grado-seccion-crudlist.component';
import { GradoSeccionCRUDCreateComponent } from './gradoSeccionPresentation/grado-seccion-crudcreate/grado-seccion-crudcreate.component';
import { GradoSeccionCRUDModifyComponent } from './gradoSeccionPresentation/grado-seccion-crudmodify/grado-seccion-crudmodify.component';
import { GradoSeccionCRUDInfoComponent } from './gradoSeccionPresentation/grado-seccion-crudinfo/grado-seccion-crudinfo.component';
import { DocenteCursoCRUDCreateComponent } from './docenteCursoPresentation/docente-curso-crudcreate/docente-curso-crudcreate.component';
import { DocenteCursoCRUDListComponent } from './docenteCursoPresentation/docente-curso-crudlist/docente-curso-crudlist.component';
import { DocenteCursoCRUDModifyComponent } from './docenteCursoPresentation/docente-curso-crudmodify/docente-curso-crudmodify.component';
import { DocenteCursoCRUDInfoComponent } from './docenteCursoPresentation/docente-curso-crudinfo/docente-curso-crudinfo.component';
import { RegistroMatriculaCRUDCreateComponent } from './registroMatriculaPresentation/registro-matricula-crudcreate/registro-matricula-crudcreate.component';
import { RegistroMatriculaCRUDListComponent } from './registroMatriculaPresentation/registro-matricula-crudlist/registro-matricula-crudlist.component';
import { RegistroMatriculaCRUDModifyComponent } from './registroMatriculaPresentation/registro-matricula-crudmodify/registro-matricula-crudmodify.component';
import { RegistroMatriculaCRUDInfoComponent } from './registroMatriculaPresentation/registro-matricula-crudinfo/registro-matricula-crudinfo.component';
import { RegistroCalificacionCRUDCreateComponent } from './registroCalificacionPresentation/registro-calificacion-crudcreate/registro-calificacion-crudcreate.component';
import { RegistroCalificacionCRUDListComponent } from './registroCalificacionPresentation/registro-calificacion-crudlist/registro-calificacion-crudlist.component';
import { RegistroCalificacionCRUDInfoComponent } from './registroCalificacionPresentation/registro-calificacion-crudinfo/registro-calificacion-crudinfo.component';
import { LoginComponent } from './loginPresentation/login/login.component';
import { HomeComponent } from './homePresentation/home/home.component';
import { AuthGuardService } from './loginPresentation/auth-guard.service';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full' },
  {path: 'login',component:LoginComponent},
  {path: 'home', component:HomeComponent, canActivate: [AuthGuardService]},

  {path: 'estudiante',component:EstudianteCRUDListComponentComponent},
  {path: 'estudiante/guardar',component:EstudianteCRUDCreateComponentComponent},
  {path: 'estudiante/modificar',component:EstudianteCRUDModifyComponentComponent},
  {path: 'estudiante/info',component:EstudianteCRUDInfoComponentComponent},

  {path: 'docente',component:DocenteCRUDListComponentComponent},
  {path: 'docente/guardar',component:DocenteCRUDCreateComponentComponent},
  {path: 'docente/modificar',component:DocenteCRUDModifyComponentComponent},
  {path: 'docente/info',component:DocenteCRUDInfoComponentComponent},

  {path: 'secretario',component:SecretarioCRUDListComponentComponent},
  {path: 'secretario/guardar',component:SecretarioCRUDCreateComponentComponent},
  {path: 'secretario/modificar',component:SecretarioCRUDModifyComponentComponent},
  {path: 'secretario/info',component:SecretarioCRUDInfoComponentComponent},

  {path: 'curso',component:CursoCRUDListComponentComponent},
  {path: 'curso/guardar',component:CursoCRUDCreateComponentComponent},
  {path: 'curso/modificar',component:CursoCRUDModifyComponentComponent},
  {path: 'curso/info',component:CursoCRUDInfoComponentComponent},

  {path: 'perfil',component:UsuarioCRUDListComponent},
  {path: 'perfil/guardar',component:UsuarioCRUDCreateComponent},
  {path: 'perfil/info',component:UsuarioCRUDInfoComponent},

  {path: 'gradoSeccion',component:GradoSeccionCRUDListComponent},
  {path: 'gradoSeccion/guardar',component:GradoSeccionCRUDCreateComponent},
  {path: 'gradoSeccion/modificar',component:GradoSeccionCRUDModifyComponent},
  {path: 'gradoSeccion/info',component:GradoSeccionCRUDInfoComponent},

  {path: 'docenteCurso',component:DocenteCursoCRUDListComponent},
  {path: 'docenteCurso/guardar',component:DocenteCursoCRUDCreateComponent},
  {path: 'docenteCurso/modificar',component:DocenteCursoCRUDModifyComponent},
  {path: 'docenteCurso/info',component:DocenteCursoCRUDInfoComponent},

  {path: 'registroMatricula',component:RegistroMatriculaCRUDListComponent},
  {path: 'registroMatricula/guardar',component:RegistroMatriculaCRUDCreateComponent},
  {path: 'registroMatricula/modificar',component:RegistroMatriculaCRUDModifyComponent},
  {path: 'registroMatricula/info',component:RegistroMatriculaCRUDInfoComponent},

  {path: 'registroCalificacion',component:RegistroCalificacionCRUDListComponent},
  {path: 'registroCalificacion/guardar',component:RegistroCalificacionCRUDCreateComponent},
  {path: 'registroCalificacion/info',component:RegistroCalificacionCRUDInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
