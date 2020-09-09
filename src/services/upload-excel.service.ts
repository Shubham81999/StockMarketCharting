import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse, HttpRequest, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, Subject, BehaviorSubject } from 'rxjs';
import { FileUploadResult } from '../model/FileUploadResult';
import { ApiRequestService } from './api-request.service';

@Injectable({
  providedIn: 'root'
})
export class UploadExcelService {
  fileData: any;
  constructor(private http: HttpClient, private apiRequestService: ApiRequestService) { }
  fileUpload(file: any): Observable<any> {
    let fileUploadSubject: BehaviorSubject<any> = new BehaviorSubject<any>([]);
    let fileUploadResult: FileUploadResult;
    const formData = new FormData();
    formData.append('file', file, file.name);
    this.apiRequestService.postFiles(formData).subscribe(
      (respData) => {
        fileUploadResult = {
          companyName: respData.companyName,
          stockExchange: respData.stockExchange,
          recordNumber: respData.recordNumber,
          fromDate: respData.fromDate,
          toDate: respData.toDate
        };
        fileUploadSubject.next(fileUploadResult);
      });
    return fileUploadSubject;
  }
}
