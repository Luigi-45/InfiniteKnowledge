import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteCRUDListComponentComponent } from './docente-crudlist-component.component';

describe('DocenteCRUDListComponentComponent', () => {
  let component: DocenteCRUDListComponentComponent;
  let fixture: ComponentFixture<DocenteCRUDListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocenteCRUDListComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocenteCRUDListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
