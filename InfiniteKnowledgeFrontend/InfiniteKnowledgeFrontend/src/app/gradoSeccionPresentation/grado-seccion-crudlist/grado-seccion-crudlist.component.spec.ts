import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradoSeccionCRUDListComponent } from './grado-seccion-crudlist.component';

describe('GradoSeccionCRUDListComponent', () => {
  let component: GradoSeccionCRUDListComponent;
  let fixture: ComponentFixture<GradoSeccionCRUDListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradoSeccionCRUDListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GradoSeccionCRUDListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
