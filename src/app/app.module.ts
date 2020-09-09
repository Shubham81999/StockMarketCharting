import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { AdminLandingComponent } from './admin-landing/admin-landing.component';
import { UserLandingComponent } from './user-landing/user-landing.component';
import { UploadExcelComponent } from './upload-excel/upload-excel.component';
import { AddCompanyComponent } from './add-company/add-company.component';
import { CompanyListComponent } from './company-list/company-list.component';
import { StockexchangeListComponent } from './stockexchange-list/stockexchange-list.component';
import { AddStockexchangeComponent } from './add-stockexchange/add-stockexchange.component';
import { AddIpoComponent } from './add-ipo/add-ipo.component';
import { SearchComponent } from './search/search.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { ViewIPOComponent } from './view-IPO/view-IPO.component';
import { CompareCompanyComponent } from './compare-company/compare-company.component';
import { CompareSectorComponent } from './compare-sector/compare-sector.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import {ApiRequestService} from './../services/api-request.service';
import {AuthGuard} from './../services/auth_guard.service';
import {ComanyService} from './../services/comany.service';
import {LoginService} from './../services/login.service';
import {StockexchangeService} from './../services/stockexchange.service';
import {UploadExcelService} from './../services/upload-excel.service';
import {UserInfoService} from './../services/user-info.service';

@NgModule({
  declarations: [
    SignupComponent,
    LoginComponent,
    AdminLandingComponent,
    UserLandingComponent,
    UploadExcelComponent,
    AddCompanyComponent,
    CompanyListComponent,
    StockexchangeListComponent,
    AddStockexchangeComponent,
    AddIpoComponent,
    SearchComponent,
    AdminHomeComponent,
    UserHomeComponent,
    ViewIPOComponent,
    CompareCompanyComponent,
    CompareSectorComponent,
    UpdateProfileComponent,
    AppComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ApiRequestService, AuthGuard, ComanyService, LoginService,StockexchangeService,UploadExcelService,UserInfoService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
