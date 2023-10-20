import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoCRUDModifyComponentComponent } from './curso-crudmodify-component.component';

describe('CursoCRUDModifyComponentComponent', () => {
  let component: CursoCRUDModifyComponentComponent;
  let fixture: ComponentFixture<CursoCRUDModifyComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursoCRUDModifyComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursoCRUDModifyComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
