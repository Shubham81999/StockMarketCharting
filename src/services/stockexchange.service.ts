import { Injectable } from '@angular/core';
import { ApiRequestService } from './api-request.service';
import { Observable, Subject, BehaviorSubject } from 'rxjs';
import { UserInfoService, UserInfoStorage } from './user-info.service';
@Injectable({
  providedIn: 'root'
})
export class StockexchangeService {

  constructor(private apiRequestService: ApiRequestService, private userInfoService: UserInfoService) { }
  addNewStockExchang(obj: any): Observable<any> {
    let addResult = new Subject<any>();
    this.apiRequestService.post('/microservice_logindata/stockexchange/add', obj).subscribe((data) => {
      addResult.next(data.addStockExchangeStatus);
    });
    return addResult;
  }

  getAllStockExchangs(): Observable<any> {
    return this.apiRequestService.get('/stockExchange-service/stockexchange/all');
  }
}
