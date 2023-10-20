import { TestBed } from '@angular/core/testing';

import { EstudianteGatewayService } from './estudiante-gateway.service';

describe('EstudianteGatewayService', () => {
  let service: EstudianteGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EstudianteGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
