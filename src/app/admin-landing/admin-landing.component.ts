import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserInfoService } from '../../services/user-info.service';
import { ComanyService } from '../../services/comany.service';
import { Company } from 'src/model/company';

@Component({
  selector: 'app-admin-landing',
  templateUrl: './admin-landing.component.html',
  styleUrls: ['./admin-landing.component.css']
})
export class AdminLandingComponent implements OnInit {

  constructor(private router: Router, private userInfoService: UserInfoService, private companyService: ComanyService) { }
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