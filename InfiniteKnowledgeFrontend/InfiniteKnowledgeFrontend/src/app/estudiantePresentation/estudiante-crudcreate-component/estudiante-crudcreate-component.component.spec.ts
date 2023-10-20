import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstudianteCRUDCreateComponentComponent } from './estudiante-crudcreate-component.component';

describe('EstudianteCRUDCreateComponentComponent', () => {
  let component: EstudianteCRUDCreateComponentComponent;
  let fixture: ComponentFixture<EstudianteCRUDCreateComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstudianteCRUDCreateComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstudianteCRUDCreateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
