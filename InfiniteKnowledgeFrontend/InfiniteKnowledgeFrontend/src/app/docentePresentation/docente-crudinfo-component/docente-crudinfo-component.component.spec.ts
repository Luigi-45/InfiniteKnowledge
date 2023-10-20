import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteCRUDInfoComponentComponent } from './docente-crudinfo-component.component';

describe('DocenteCRUDInfoComponentComponent', () => {
  let component: DocenteCRUDInfoComponentComponent;
  let fixture: ComponentFixture<DocenteCRUDInfoComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocenteCRUDInfoComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocenteCRUDInfoComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
