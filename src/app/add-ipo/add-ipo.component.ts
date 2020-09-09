import { Component, OnInit } from '@angular/core';
import { ComanyService } from '../../services/comany.service'
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-add-ipo',
  templateUrl: './add-ipo.component.html',
  styleUrls: ['./add-ipo.component.css']
})
export class AddIpoComponent implements OnInit {

  constructor(private companyService: ComanyService) { }
  isShow = false;
  addIPOForm = new FormGroup({
    companyName: new FormControl(''),
    stockExchange: new FormControl(''),
    price: new FormControl(''),
    totalNumber: new FormControl(''),
    openDate: new FormControl(''),
    remarks: new FormControl('')
  });

  ngOnInit() {
  }

  addIPO() {
    let userInput: any = {
      companyName: this.addIPOForm.get('companyName').value,
      stockExchange: this.addIPOForm.get('stockExchange').value,
      price: this.addIPOForm.get('price').value,
      totalNumber: this.addIPOForm.get('totalNumber').value,
      openDate: this.addIPOForm.get('openDate').value,
      remarks: this.addIPOForm.get('remarks').value,
    };
    this.companyService.addNewIPO(userInput).subscribe(
      resp => {
        if (resp === 'successful') {
          this.isShow = true;
        }
      });
  }
}
// n