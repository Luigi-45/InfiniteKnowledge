import { TestBed } from '@angular/core/testing';

import { RegistroMatriculaGatewayService } from './registro-matricula-gateway.service';

describe('RegistroMatriculaGatewayService', () => {
  let service: RegistroMatriculaGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistroMatriculaGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
