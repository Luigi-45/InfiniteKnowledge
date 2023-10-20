import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioCRUDListComponent } from './usuario-crudlist.component';

describe('UsuarioCRUDListComponent', () => {
  let component: UsuarioCRUDListComponent;
  let fixture: ComponentFixture<UsuarioCRUDListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuarioCRUDListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioCRUDListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
