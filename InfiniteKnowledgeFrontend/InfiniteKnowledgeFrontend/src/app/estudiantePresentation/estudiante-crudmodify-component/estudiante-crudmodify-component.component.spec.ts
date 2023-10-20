import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstudianteCRUDModifyComponentComponent } from './estudiante-crudmodify-component.component';

describe('EstudianteCRUDModifyComponentComponent', () => {
  let component: EstudianteCRUDModifyComponentComponent;
  let fixture: ComponentFixture<EstudianteCRUDModifyComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstudianteCRUDModifyComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstudianteCRUDModifyComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
