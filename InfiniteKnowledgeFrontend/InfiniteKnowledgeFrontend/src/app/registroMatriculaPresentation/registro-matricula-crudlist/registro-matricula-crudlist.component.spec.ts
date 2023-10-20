import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroMatriculaCRUDListComponent } from './registro-matricula-crudlist.component';

describe('RegistroMatriculaCRUDListComponent', () => {
  let component: RegistroMatriculaCRUDListComponent;
  let fixture: ComponentFixture<RegistroMatriculaCRUDListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroMatriculaCRUDListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroMatriculaCRUDListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
