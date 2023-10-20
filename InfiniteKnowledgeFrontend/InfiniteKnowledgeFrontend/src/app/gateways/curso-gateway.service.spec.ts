import { TestBed } from '@angular/core/testing';

import { CursoGatewayService } from './curso-gateway.service';

describe('CursoGatewayService', () => {
  let service: CursoGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CursoGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
