import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteCRUDCreateComponentComponent } from './docente-crudcreate-component.component';

describe('DocenteCRUDCreateComponentComponent', () => {
  let component: DocenteCRUDCreateComponentComponent;
  let fixture: ComponentFixture<DocenteCRUDCreateComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocenteCRUDCreateComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocenteCRUDCreateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
