/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { Auth_guardService } from './auth_guard.service';

describe('Service: Auth_guard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Auth_guardService]
    });
  });

  it('should ...', inject([Auth_guardService], (service: Auth_guardService) => {
    expect(service).toBeTruthy();
  }));
});
