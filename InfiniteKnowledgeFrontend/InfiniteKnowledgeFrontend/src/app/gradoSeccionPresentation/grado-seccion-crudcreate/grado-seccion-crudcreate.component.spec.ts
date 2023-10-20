import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradoSeccionCRUDCreateComponent } from './grado-seccion-crudcreate.component';

describe('GradoSeccionCRUDCreateComponent', () => {
  let component: GradoSeccionCRUDCreateComponent;
  let fixture: ComponentFixture<GradoSeccionCRUDCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradoSeccionCRUDCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GradoSeccionCRUDCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
