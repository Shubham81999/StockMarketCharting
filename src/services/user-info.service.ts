import { Injectable } from '@angular/core';

export class UserInfoStorage {
  username: string;
  status: string;
  role: string;
  token: string;
}

@Injectable()
export class UserInfoService {

  public currentUserKey = 'currentUser';
  public storage: Storage = sessionStorage;

  constructor() { }

  // Store userinfo from session storage
  storeUserInfo(userInfoString: string) {
    this.storage.setItem(this.currentUserKey, userInfoString);
  }

  // Remove userinfo from session storage
  removeUserInfo() {
    this.storage.removeItem(this.currentUserKey);
  }

  // Get userinfo from session storage
  getUserInfo(): UserInfoStorage | null {
    try {
      const userInfoString: string = this.storage.getItem(this.currentUserKey);
      if (userInfoString) {
        const userObj: UserInfoStorage = JSON.parse(this.storage.getItem(this.currentUserKey));
        return userObj;
      } else {
        return null;
      }
    } catch (e) {
      return null;
    }
  }

  isLoggedIn(): boolean {
    return this.storage.getItem(this.currentUserKey) ? true : false;
  }

  getStoredToken(): string | null {
    const userObj: UserInfoStorage = this.getUserInfo();
    if (userObj !== null) {
      return userObj.token;
    }
    return null;
  }

}
