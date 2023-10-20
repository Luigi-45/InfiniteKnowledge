import { TestBed } from '@angular/core/testing';

import { RegistroCalificacionGatewayService } from './registro-calificacion-gateway.service';

describe('RegistroCalificacionGatewayService', () => {
  let service: RegistroCalificacionGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistroCalificacionGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
