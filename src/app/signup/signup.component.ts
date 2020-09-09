import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  constructor(private loginService: LoginService, private router: Router) { }
  signupForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    email: new FormControl(''),
    mobile: new FormControl('')
  });
  ngOnInit() {
  }

  signUp() {
    const userInput: any = {
      username: this.signupForm.get('username').value,
      password: this.signupForm.get('password').value,
      mobile: this.signupForm.get('mobile').value,
      email: this.signupForm.get('email').value
    };
    this.loginService.signUp(userInput).subscribe(
      resp => {
        if (resp === 'successful') {
          this.router.navigate(['login']);
        }
      });
  }
}
// n