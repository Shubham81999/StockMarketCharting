import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse, HttpRequest, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { UserInfoService } from './user-info.service';

@Injectable({
  providedIn: 'root'
})
export class ApiRequestService {

  private baseApiPath = 'http://localhost:8888';
  constructor(
    private http: HttpClient,
    private router: Router,
    private userInfoService: UserInfoService
  ) { }

  /**
   * This is a Global place to add all the request headers for every REST calls
   */
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    const token = this.userInfoService.getStoredToken();
    headers = headers.append('Content-Type', 'application/json');
    if (token !== null) {
      headers = headers.append('Authorization', token);
    }
    return headers;
  }

  get(url: string, urlParams?: HttpParams): Observable<any> {
    return this.http.get(this.baseApiPath + url, { headers: this.getHeaders(), params: urlParams });
  }

  post(url: string, body: any): Observable<any> {
    return this.http.post(this.baseApiPath + url, JSON.stringify(body), { headers: this.getHeaders() });
  }

  postFiles(formData: FormData): Observable<any> {
    return this.http.post(this.baseApiPath + '/microservice_spreadsheet/excel/upload', formData);
  }

}
