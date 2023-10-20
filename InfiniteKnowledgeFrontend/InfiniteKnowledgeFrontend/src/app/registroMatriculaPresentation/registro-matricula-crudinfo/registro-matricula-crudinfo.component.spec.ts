import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroMatriculaCRUDInfoComponent } from './registro-matricula-crudinfo.component';

describe('RegistroMatriculaCRUDInfoComponent', () => {
  let component: RegistroMatriculaCRUDInfoComponent;
  let fixture: ComponentFixture<RegistroMatriculaCRUDInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroMatriculaCRUDInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroMatriculaCRUDInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
