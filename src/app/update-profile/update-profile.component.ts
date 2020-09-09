import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { LoginService } from '../../services/login.service';
import { FormGroup, FormControl } from '@angular/forms';
import { UserInfoService, UserInfoStorage } from '../../services/user-info.service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  constructor(private loginService: LoginService, private userInfoService: UserInfoService) { }
  userProfile: User;
  isShow = false;
  updateProfileForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    mobile: new FormControl(''),
    email: new FormControl('')
  });
// n
  ngOnInit() {
    this.getUserProfile();
  }

  getUserProfile() {
    let userInfo: UserInfoStorage = this.userInfoService.getUserInfo();
    let username: string = userInfo.username;
    this.loginService.getUserProfile(username).subscribe(
      data => {
        this.userProfile = data;
        this.updateProfileForm.get('username').setValue(this.userProfile.username);
        this.updateProfileForm.get('password').setValue(this.userProfile.password);
        this.updateProfileForm.get('mobile').setValue(this.userProfile.mobile);
        this.updateProfileForm.get('email').setValue(this.userProfile.email);
      });
  }

  updateProfile() {
    let userInput: any = {
      username: this.updateProfileForm.get('username').value,
      password: this.updateProfileForm.get('password').value,
      mobile: this.updateProfileForm.get('mobile').value,
      email: this.updateProfileForm.get('email').value,
    };
    this.loginService.updateUserProfile(userInput).subscribe(
      resp => {
        if (resp === 'successful') {
          this.isShow = true;
        }
      });
  }

}
