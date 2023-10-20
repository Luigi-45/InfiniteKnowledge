import { TestBed } from '@angular/core/testing';

import { UsuarioGatewayService } from './usuario-gateway.service';

describe('UsuarioGatewayService', () => {
  let service: UsuarioGatewayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsuarioGatewayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
