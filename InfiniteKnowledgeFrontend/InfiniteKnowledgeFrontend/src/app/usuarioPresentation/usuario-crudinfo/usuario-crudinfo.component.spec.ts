import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioCRUDInfoComponent } from './usuario-crudinfo.component';

describe('UsuarioCRUDInfoComponent', () => {
  let component: UsuarioCRUDInfoComponent;
  let fixture: ComponentFixture<UsuarioCRUDInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuarioCRUDInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioCRUDInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
