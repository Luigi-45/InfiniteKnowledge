import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteCursoCRUDCreateComponent } from './docente-curso-crudcreate.component';

describe('DocenteCursoCRUDCreateComponent', () => {
  let component: DocenteCursoCRUDCreateComponent;
  let fixture: ComponentFixture<DocenteCursoCRUDCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocenteCursoCRUDCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocenteCursoCRUDCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
