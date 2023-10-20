import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstudianteCRUDInfoComponentComponent } from './estudiante-crudinfo-component.component';

describe('EstudianteCRUDInfoComponentComponent', () => {
  let component: EstudianteCRUDInfoComponentComponent;
  let fixture: ComponentFixture<EstudianteCRUDInfoComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstudianteCRUDInfoComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstudianteCRUDInfoComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
