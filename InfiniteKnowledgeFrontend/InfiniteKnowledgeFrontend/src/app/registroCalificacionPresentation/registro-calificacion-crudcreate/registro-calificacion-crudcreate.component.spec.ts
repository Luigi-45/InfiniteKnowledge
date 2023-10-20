import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroCalificacionCRUDCreateComponent } from './registro-calificacion-crudcreate.component';

describe('RegistroCalificacionCRUDCreateComponent', () => {
  let component: RegistroCalificacionCRUDCreateComponent;
  let fixture: ComponentFixture<RegistroCalificacionCRUDCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroCalificacionCRUDCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroCalificacionCRUDCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
