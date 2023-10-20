import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteCursoCRUDInfoComponent } from './docente-curso-crudinfo.component';

describe('DocenteCursoCRUDInfoComponent', () => {
  let component: DocenteCursoCRUDInfoComponent;
  let fixture: ComponentFixture<DocenteCursoCRUDInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocenteCursoCRUDInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocenteCursoCRUDInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
