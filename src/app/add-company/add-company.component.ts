import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ComanyService } from '../../services/comany.service'

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {
  constructor(private companyService: ComanyService) { }
  isShow = false;
  addCompanyForm = new FormGroup({
    companyName: new FormControl(''),
    turnover: new FormControl(''),
    ceo: new FormControl(''),
    stockExchange: new FormControl(''),
    boardDirector: new FormControl(''),
    sector: new FormControl(''),
    writeup: new FormControl(''),
    companyCode: new FormControl('')
  });
  ngOnInit() {
  }

  addCompany() {
    let userInput: any = {
      companyName: this.addCompanyForm.get('companyName').value,
      turnover: this.addCompanyForm.get('turnover').value,
      ceo: this.addCompanyForm.get('ceo').value,
      stockExchange: this.addCompanyForm.get('stockExchange').value,
      boardDirector: this.addCompanyForm.get('boardDirector').value,
      sector: this.addCompanyForm.get('sector').value,
      writeup: this.addCompanyForm.get('writeup').value,
      companyCode: this.addCompanyForm.get('companyCode').value
    };
    this.companyService.addNewCompany(userInput).subscribe(
      resp => {
        if (resp === 'successful') {
          this.isShow = true;
        }
      });
  }
}
// n