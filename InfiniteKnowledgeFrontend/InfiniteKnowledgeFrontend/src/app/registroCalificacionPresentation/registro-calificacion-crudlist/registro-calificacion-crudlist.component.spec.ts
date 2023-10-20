import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroCalificacionCRUDListComponent } from './registro-calificacion-crudlist.component';

describe('RegistroCalificacionCRUDListComponent', () => {
  let component: RegistroCalificacionCRUDListComponent;
  let fixture: ComponentFixture<RegistroCalificacionCRUDListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroCalificacionCRUDListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroCalificacionCRUDListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
