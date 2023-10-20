import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroMatriculaCRUDModifyComponent } from './registro-matricula-crudmodify.component';

describe('RegistroMatriculaCRUDModifyComponent', () => {
  let component: RegistroMatriculaCRUDModifyComponent;
  let fixture: ComponentFixture<RegistroMatriculaCRUDModifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroMatriculaCRUDModifyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroMatriculaCRUDModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
