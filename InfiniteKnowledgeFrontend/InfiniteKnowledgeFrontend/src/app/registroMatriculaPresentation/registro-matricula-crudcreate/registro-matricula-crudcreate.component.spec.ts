import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroMatriculaCRUDCreateComponent } from './registro-matricula-crudcreate.component';

describe('RegistroMatriculaCRUDCreateComponent', () => {
  let component: RegistroMatriculaCRUDCreateComponent;
  let fixture: ComponentFixture<RegistroMatriculaCRUDCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroMatriculaCRUDCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroMatriculaCRUDCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
