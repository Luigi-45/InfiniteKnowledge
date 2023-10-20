import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteCursoCRUDListComponent } from './docente-curso-crudlist.component';

describe('DocenteCursoCRUDListComponent', () => {
  let component: DocenteCursoCRUDListComponent;
  let fixture: ComponentFixture<DocenteCursoCRUDListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocenteCursoCRUDListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocenteCursoCRUDListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
