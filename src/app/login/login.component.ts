import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }
  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });
  ngOnInit() {
  }

  onLogin() {
    const userInput: any = {
      username: this.loginForm.get('username').value,
      password: this.loginForm.get('password').value,
    };
    this.loginService.login(userInput).subscribe(
      resp => {
        if (resp.status === 'successful' && resp.role === 'admin') {
          this.router.navigate(['adminHome']);
        }
        if (resp.status === 'successful' && resp.role === 'user') {
          this.router.navigate(['userHome']);
        }
      });
  }

  onSignup() {
    this.router.navigate(['signup']);
  }
}
// n