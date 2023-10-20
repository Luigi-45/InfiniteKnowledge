import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstudianteCRUDListComponentComponent } from './estudiante-crudlist-component.component';

describe('EstudianteCRUDListComponentComponent', () => {
  let component: EstudianteCRUDListComponentComponent;
  let fixture: ComponentFixture<EstudianteCRUDListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstudianteCRUDListComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstudianteCRUDListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
