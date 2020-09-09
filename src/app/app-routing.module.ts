import { NgModule } from '@angular/core';
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

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: 'adminLanding', component: AdminLandingComponent },
  { path: 'userLanding', component: UserLandingComponent },
  { path: 'excel', component: UploadExcelComponent },
  { path: 'company/add', component: AddCompanyComponent },
  { path: 'company/list', component: CompanyListComponent },
  { path: 'stockexchange/list', component: StockexchangeListComponent },
  { path: 'stockexchange/add', component: AddStockexchangeComponent },
  { path: 'ipo/add', component: AddIpoComponent },
  { path: 'search', component: SearchComponent },
  { path: 'adminHome', component: AdminHomeComponent },
  { path: 'userHome', component: UserHomeComponent },
  { path: 'ipo/view', component: ViewIPOComponent },
  { path: 'compare/company', component: CompareCompanyComponent },
  { path: 'compare/sector', component: CompareSectorComponent },
  { path: 'profile', component: UpdateProfileComponent }

];
// n
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
