import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecretarioCRUDModifyComponentComponent } from './secretario-crudmodify-component.component';

describe('SecretarioCRUDModifyComponentComponent', () => {
  let component: SecretarioCRUDModifyComponentComponent;
  let fixture: ComponentFixture<SecretarioCRUDModifyComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SecretarioCRUDModifyComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SecretarioCRUDModifyComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
