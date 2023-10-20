import { TestBed } from '@angular/core/testing';

import { GradoSeccionGatewayService } from './grado-seccion-gateway.service';

describe('GradoSeccionGatewayService', () => {
  let service: GradoSeccionGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GradoSeccionGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
