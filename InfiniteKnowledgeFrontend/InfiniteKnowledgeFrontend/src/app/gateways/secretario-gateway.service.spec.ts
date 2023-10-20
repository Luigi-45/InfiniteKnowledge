import { TestBed } from '@angular/core/testing';

import { SecretarioGatewayService } from './secretario-gateway.service';

describe('SecretarioGatewayService', () => {
  let service: SecretarioGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SecretarioGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
