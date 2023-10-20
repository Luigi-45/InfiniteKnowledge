import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradoSeccionCRUDInfoComponent } from './grado-seccion-crudinfo.component';

describe('GradoSeccionCRUDInfoComponent', () => {
  let component: GradoSeccionCRUDInfoComponent;
  let fixture: ComponentFixture<GradoSeccionCRUDInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradoSeccionCRUDInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GradoSeccionCRUDInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
