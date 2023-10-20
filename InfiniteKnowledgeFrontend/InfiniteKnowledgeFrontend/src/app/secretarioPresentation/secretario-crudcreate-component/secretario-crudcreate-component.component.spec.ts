import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecretarioCRUDCreateComponentComponent } from './secretario-crudcreate-component.component';

describe('SecretarioCRUDCreateComponentComponent', () => {
  let component: SecretarioCRUDCreateComponentComponent;
  let fixture: ComponentFixture<SecretarioCRUDCreateComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SecretarioCRUDCreateComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SecretarioCRUDCreateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
