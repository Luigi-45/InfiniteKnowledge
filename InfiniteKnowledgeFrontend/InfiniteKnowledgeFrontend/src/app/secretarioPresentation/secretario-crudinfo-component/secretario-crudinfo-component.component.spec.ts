import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecretarioCRUDInfoComponentComponent } from './secretario-crudinfo-component.component';

describe('SecretarioCRUDInfoComponentComponent', () => {
  let component: SecretarioCRUDInfoComponentComponent;
  let fixture: ComponentFixture<SecretarioCRUDInfoComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SecretarioCRUDInfoComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SecretarioCRUDInfoComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
