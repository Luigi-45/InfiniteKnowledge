import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteCRUDModifyComponentComponent } from './docente-crudmodify-component.component';

describe('DocenteCRUDModifyComponentComponent', () => {
  let component: DocenteCRUDModifyComponentComponent;
  let fixture: ComponentFixture<DocenteCRUDModifyComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocenteCRUDModifyComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocenteCRUDModifyComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
