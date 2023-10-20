import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EstudianteCRUDListComponentComponent } from './estudiantePresentation/estudiante-crudlist-component/estudiante-crudlist-component.component';
import { EstudianteCRUDCreateComponentComponent } from './estudiantePresentation/estudiante-crudcreate-component/estudiante-crudcreate-component.component';
import { EstudianteCRUDModifyComponentComponent } from './estudiantePresentation/estudiante-crudmodify-component/estudiante-crudmodify-component.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EstudianteCRUDInfoComponentComponent } from './estudiantePresentation/estudiante-crudinfo-component/estudiante-crudinfo-component.component';
import { DocenteCRUDCreateComponentComponent } from './docentePresentation/docente-crudcreate-component/docente-crudcreate-component.component';
import { DocenteCRUDInfoComponentComponent } from './docentePresentation/docente-crudinfo-component/docente-crudinfo-component.component';
import { DocenteCRUDListComponentComponent } from './docentePresentation/docente-crudlist-component/docente-crudlist-component.component';
import { DocenteCRUDModifyComponentComponent } from './docentePresentation/docente-crudmodify-component/docente-crudmodify-component.component';
import { SecretarioCRUDListComponentComponent } from './secretarioPresentation/secretario-crudlist-component/secretario-crudlist-component.component';
import { SecretarioCRUDCreateComponentComponent } from './secretarioPresentation/secretario-crudcreate-component/secretario-crudcreate-component.component';
import { SecretarioCRUDModifyComponentComponent } from './secretarioPresentation/secretario-crudmodify-component/secretario-crudmodify-component.component';
import { SecretarioCRUDInfoComponentComponent } from './secretarioPresentation/secretario-crudinfo-component/secretario-crudinfo-component.component';
import { CursoCRUDListComponentComponent } from './cursoPresentation/curso-crudlist-component/curso-crudlist-component.component';
import { CursoCRUDCreateComponentComponent } from './cursoPresentation/curso-crudcreate-component/curso-crudcreate-component.component';
import { CursoCRUDInfoComponentComponent } from './cursoPresentation/curso-crudinfo-component/curso-crudinfo-component.component';
import { CursoCRUDModifyComponentComponent } from './cursoPresentation/curso-crudmodify-component/curso-crudmodify-component.component';
import { UsuarioCRUDCreateComponent } from './usuarioPresentation/usuario-crudcreate/usuario-crudcreate.component';
import { UsuarioCRUDInfoComponent } from './usuarioPresentation/usuario-crudinfo/usuario-crudinfo.component';
import { UsuarioCRUDListComponent } from './usuarioPresentation/usuario-crudlist/usuario-crudlist.component';
import { GradoSeccionCRUDCreateComponent } from './gradoSeccionPresentation/grado-seccion-crudcreate/grado-seccion-crudcreate.component';
import { GradoSeccionCRUDInfoComponent } from './gradoSeccionPresentation/grado-seccion-crudinfo/grado-seccion-crudinfo.component';
import { GradoSeccionCRUDListComponent } from './gradoSeccionPresentation/grado-seccion-crudlist/grado-seccion-crudlist.component';
import { GradoSeccionCRUDModifyComponent } from './gradoSeccionPresentation/grado-seccion-crudmodify/grado-seccion-crudmodify.component';
import { DocenteCursoCRUDCreateComponent } from './docenteCursoPresentation/docente-curso-crudcreate/docente-curso-crudcreate.component';
import { DocenteCursoCRUDInfoComponent } from './docenteCursoPresentation/docente-curso-crudinfo/docente-curso-crudinfo.component';
import { DocenteCursoCRUDListComponent } from './docenteCursoPresentation/docente-curso-crudlist/docente-curso-crudlist.component';
import { DocenteCursoCRUDModifyComponent } from './docenteCursoPresentation/docente-curso-crudmodify/docente-curso-crudmodify.component';
import { RegistroMatriculaCRUDCreateComponent } from './registroMatriculaPresentation/registro-matricula-crudcreate/registro-matricula-crudcreate.component';
import { RegistroMatriculaCRUDInfoComponent } from './registroMatriculaPresentation/registro-matricula-crudinfo/registro-matricula-crudinfo.component';
import { RegistroMatriculaCRUDListComponent } from './registroMatriculaPresentation/registro-matricula-crudlist/registro-matricula-crudlist.component';
import { RegistroMatriculaCRUDModifyComponent } from './registroMatriculaPresentation/registro-matricula-crudmodify/registro-matricula-crudmodify.component';
import { RegistroCalificacionCRUDCreateComponent } from './registroCalificacionPresentation/registro-calificacion-crudcreate/registro-calificacion-crudcreate.component';
import { RegistroCalificacionCRUDInfoComponent } from './registroCalificacionPresentation/registro-calificacion-crudinfo/registro-calificacion-crudinfo.component';
import { RegistroCalificacionCRUDListComponent } from './registroCalificacionPresentation/registro-calificacion-crudlist/registro-calificacion-crudlist.component';
import { LoginComponent } from './loginPresentation/login/login.component';
import { HomeComponent } from './homePresentation/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    EstudianteCRUDListComponentComponent,
    EstudianteCRUDCreateComponentComponent,
    EstudianteCRUDModifyComponentComponent,
    EstudianteCRUDInfoComponentComponent,
    DocenteCRUDCreateComponentComponent,
    DocenteCRUDInfoComponentComponent,
    DocenteCRUDListComponentComponent,
    DocenteCRUDModifyComponentComponent,
    SecretarioCRUDListComponentComponent,
    SecretarioCRUDCreateComponentComponent,
    SecretarioCRUDModifyComponentComponent,
    SecretarioCRUDInfoComponentComponent,
    CursoCRUDListComponentComponent,
    CursoCRUDCreateComponentComponent,
    CursoCRUDInfoComponentComponent,
    CursoCRUDModifyComponentComponent,
    UsuarioCRUDCreateComponent,
    UsuarioCRUDInfoComponent,
    UsuarioCRUDListComponent,
    GradoSeccionCRUDCreateComponent,
    GradoSeccionCRUDInfoComponent,
    GradoSeccionCRUDListComponent,
    GradoSeccionCRUDModifyComponent,
    DocenteCursoCRUDCreateComponent,
    DocenteCursoCRUDInfoComponent,
    DocenteCursoCRUDListComponent,
    DocenteCursoCRUDModifyComponent,
    RegistroMatriculaCRUDCreateComponent,
    RegistroMatriculaCRUDInfoComponent,
    RegistroMatriculaCRUDListComponent,
    RegistroMatriculaCRUDModifyComponent,
    RegistroCalificacionCRUDCreateComponent,
    RegistroCalificacionCRUDInfoComponent,
    RegistroCalificacionCRUDListComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
