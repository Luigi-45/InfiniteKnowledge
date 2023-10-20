import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroCalificacionCRUDInfoComponent } from './registro-calificacion-crudinfo.component';

describe('RegistroCalificacionCRUDInfoComponent', () => {
  let component: RegistroCalificacionCRUDInfoComponent;
  let fixture: ComponentFixture<RegistroCalificacionCRUDInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroCalificacionCRUDInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroCalificacionCRUDInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
