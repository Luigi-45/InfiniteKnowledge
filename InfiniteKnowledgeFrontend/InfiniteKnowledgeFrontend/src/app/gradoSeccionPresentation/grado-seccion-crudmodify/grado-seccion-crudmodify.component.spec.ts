import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradoSeccionCRUDModifyComponent } from './grado-seccion-crudmodify.component';

describe('GradoSeccionCRUDModifyComponent', () => {
  let component: GradoSeccionCRUDModifyComponent;
  let fixture: ComponentFixture<GradoSeccionCRUDModifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradoSeccionCRUDModifyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GradoSeccionCRUDModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
