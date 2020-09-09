import { Component, OnInit } from '@angular/core';
import { Company } from 'src/model/company';
import { ComanyService } from '../../services/comany.service'
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {

  companyList: Company[];
  constructor(private companyService: ComanyService) { }
  isShow = false;
  editCompanyForm = new FormGroup({
    id: new FormControl(''),
    companyName: new FormControl(''),
    turnover: new FormControl(''),
    ceo: new FormControl(''),
    stockExchange: new FormControl(''),
    boardDirector: new FormControl(''),
    sector: new FormControl(''),
    writeup: new FormControl(''),
    companyCode: new FormControl('')
  });
// n
  ngOnInit() {
    this.getCompanyList();
  }

  getCompanyList(): void {
    this.companyService.getAllCompanies().subscribe(
      (data) => {
        this.companyList = data;
      }
    );
  }

  editCompany(comanyItem: Company): void {
    this.editCompanyForm.get('id').setValue(comanyItem.id);
    this.editCompanyForm.get('companyName').setValue(comanyItem.companyName);
    this.editCompanyForm.get('turnover').setValue(comanyItem.turnover);
    this.editCompanyForm.get('ceo').setValue(comanyItem.ceo);
    this.editCompanyForm.get('stockExchange').setValue(comanyItem.stockExchange);
    this.editCompanyForm.get('sector').setValue(comanyItem.sector);
    this.editCompanyForm.get('writeup').setValue(comanyItem.writeup);
    this.editCompanyForm.get('companyCode').setValue(comanyItem.companyCode);
    this.editCompanyForm.get('boardDirector').setValue(comanyItem.boardDirector);
  }

  updateCompany() {
    let userInput: any = {
      id: this.editCompanyForm.get('id').value,
      companyName: this.editCompanyForm.get('companyName').value,
      turnover: this.editCompanyForm.get('turnover').value,
      ceo: this.editCompanyForm.get('ceo').value,
      stockExchange: this.editCompanyForm.get('stockExchange').value,
      boardDirector: this.editCompanyForm.get('boardDirector').value,
      sector: this.editCompanyForm.get('sector').value,
      writeup: this.editCompanyForm.get('writeup').value,
      companyCode: this.editCompanyForm.get('companyCode').value
    };
    this.companyService.updateCompany(userInput).subscribe(
      resp => {
        if (resp === 'successful') {
          this.isShow = true;
        }
      });

  }

}
