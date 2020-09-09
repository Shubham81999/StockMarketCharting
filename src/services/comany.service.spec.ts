/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ComanyService } from './comany.service';

describe('Service: Comany', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ComanyService]
    });
  });

  it('should ...', inject([ComanyService], (service: ComanyService) => {
    expect(service).toBeTruthy();
  }));
});
