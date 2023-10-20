import { TestBed } from '@angular/core/testing';

import { DocenteCursoGatewayService } from './docente-curso-gateway.service';

describe('DocenteCursoGatewayService', () => {
  let service: DocenteCursoGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocenteCursoGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
