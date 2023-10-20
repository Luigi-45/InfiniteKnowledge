import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecretarioCRUDListComponentComponent } from './secretario-crudlist-component.component';

describe('SecretarioCRUDListComponentComponent', () => {
  let component: SecretarioCRUDListComponentComponent;
  let fixture: ComponentFixture<SecretarioCRUDListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SecretarioCRUDListComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SecretarioCRUDListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
