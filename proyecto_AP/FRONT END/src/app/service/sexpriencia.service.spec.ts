import { TestBed } from '@angular/core/testing';

import { SExprienciaService } from './sexpriencia.service';

describe('SExprienciaService', () => {
  let service: SExprienciaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SExprienciaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
