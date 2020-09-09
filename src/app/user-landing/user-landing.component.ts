import { Component, OnInit } from '@angular/core';
import { UserInfoService } from '../../services/user-info.service';
import { Router } from '@angular/router';
import { ComanyService } from '../../services/comany.service';
import { Company } from 'src/model/company';
@Component({
  selector: 'app-user-landing',
  templateUrl: './user-landing.component.html',
  styleUrls: ['./user-landing.component.css']
})
export class UserLandingComponent implements OnInit {

  constructor(private router: Router, private userInfoService: UserInfoService,private companyService: ComanyService) { }
  companyList: Company[];
  isShow = false;
  ngOnInit() {
  }

  onLogout() {
    this.userInfoService.removeUserInfo();
    this.router.navigate(["login"]);
  }
  
  getCompanyByName(searchStr: string) {
    this.isShow = true;
    this.companyService.getCompanyByName(searchStr).subscribe(
      (data) => {
        this.companyList = data;
      }
    );
  }
}
// n