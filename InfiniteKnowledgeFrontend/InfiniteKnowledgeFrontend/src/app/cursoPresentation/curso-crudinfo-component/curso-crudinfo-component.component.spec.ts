import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoCRUDInfoComponentComponent } from './curso-crudinfo-component.component';

describe('CursoCRUDInfoComponentComponent', () => {
  let component: CursoCRUDInfoComponentComponent;
  let fixture: ComponentFixture<CursoCRUDInfoComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursoCRUDInfoComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursoCRUDInfoComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
