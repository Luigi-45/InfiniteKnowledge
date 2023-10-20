import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoCRUDListComponentComponent } from './curso-crudlist-component.component';

describe('CursoCRUDListComponentComponent', () => {
  let component: CursoCRUDListComponentComponent;
  let fixture: ComponentFixture<CursoCRUDListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursoCRUDListComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursoCRUDListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
