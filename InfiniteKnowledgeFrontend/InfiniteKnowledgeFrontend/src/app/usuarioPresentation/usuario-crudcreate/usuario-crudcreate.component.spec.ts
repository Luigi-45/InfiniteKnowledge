import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioCRUDCreateComponent } from './usuario-crudcreate.component';

describe('UsuarioCRUDCreateComponent', () => {
  let component: UsuarioCRUDCreateComponent;
  let fixture: ComponentFixture<UsuarioCRUDCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuarioCRUDCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioCRUDCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
