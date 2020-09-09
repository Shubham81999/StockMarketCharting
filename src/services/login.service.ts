import { Injectable } from '@angular/core';
import { ApiRequestService } from './api-request.service';
import { Observable, Subject, BehaviorSubject } from 'rxjs';
import { UserInfoService, UserInfoStorage } from './user-info.service';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private apiRequestService: ApiRequestService, private userInfoService: UserInfoService) { }

  signUp(obj: any): Observable<any> {
    let signUpResult = new Subject<any>();
    let isRegistered: String;
    this.apiRequestService.post('/microservice_logindata/user/registration', obj).subscribe((data) => {
      console.log(data.signUpStatus);
      isRegistered = data.signUpStatus;
      signUpResult.next(isRegistered);
    });
    return signUpResult;
  }

  login(obj: any): Observable<any> {
    let loginDataSubject: BehaviorSubject<any> = new BehaviorSubject<any>([]);
    let loginInfoReturn: UserInfoStorage;
    this.apiRequestService.post('/microservice_logindata/user/login', obj).subscribe(
      (data) => {
        loginInfoReturn = {
          status: data.status,
          username: data.username,
          role: data.role,
          token: data.token
        };
        loginDataSubject.next(loginInfoReturn);
      }
    );
    return loginDataSubject;
  }

  getUserProfile(username: string): Observable<any> {
    return this.apiRequestService.get('/microservice_logindata/user/profile/' + username);
  }

  updateUserProfile(obj: any): Observable<any> {
    let updateResult = new Subject<any>();
    this.apiRequestService.post('/microservice_logindata/user/profile/update', obj).subscribe((data) => {
      updateResult.next(data.updateProfileStatus);
    });
    return updateResult;
  }

  logout(): void {
    this.userInfoService.removeUserInfo();
  }

}
