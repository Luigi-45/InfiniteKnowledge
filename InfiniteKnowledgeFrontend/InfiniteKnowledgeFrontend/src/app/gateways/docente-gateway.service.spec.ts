import { TestBed } from '@angular/core/testing';

import { DocenteGatewayService } from './docente-gateway.service';

describe('DocenteGatewayService', () => {
  let service: DocenteGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocenteGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
