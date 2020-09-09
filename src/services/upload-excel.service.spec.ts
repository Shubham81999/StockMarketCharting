/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { UploadExcelService } from './upload-excel.service';

describe('Service: UploadExcel', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UploadExcelService]
    });
  });

  it('should ...', inject([UploadExcelService], (service: UploadExcelService) => {
    expect(service).toBeTruthy();
  }));
});
