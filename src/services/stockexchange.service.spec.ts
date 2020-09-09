/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { StockexchangeService } from './stockexchange.service';

describe('Service: Stockexchange', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StockexchangeService]
    });
  });

  it('should ...', inject([StockexchangeService], (service: StockexchangeService) => {
    expect(service).toBeTruthy();
  }));
});
