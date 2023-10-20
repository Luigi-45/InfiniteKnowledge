import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteCursoCRUDModifyComponent } from './docente-curso-crudmodify.component';

describe('DocenteCursoCRUDModifyComponent', () => {
  let component: DocenteCursoCRUDModifyComponent;
  let fixture: ComponentFixture<DocenteCursoCRUDModifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocenteCursoCRUDModifyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocenteCursoCRUDModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
