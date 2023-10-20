import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoCRUDCreateComponentComponent } from './curso-crudcreate-component.component';

describe('CursoCRUDCreateComponentComponent', () => {
  let component: CursoCRUDCreateComponentComponent;
  let fixture: ComponentFixture<CursoCRUDCreateComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursoCRUDCreateComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursoCRUDCreateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
