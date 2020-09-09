import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { StockexchangeService } from 'src/services/stockexchange.service';

@Component({
  selector: 'app-add-stockexchange',
  templateUrl: './add-stockexchange.component.html',
  styleUrls: ['./add-stockexchange.component.css']
})
export class AddStockexchangeComponent implements OnInit {

  constructor(private stockexchangeService: StockexchangeService) { }
  isShow = false;
  addStockExchangeForm = new FormGroup({
    stockExchange: new FormControl(''),
    brief: new FormControl(''),
    address: new FormControl(''),
    remarks: new FormControl('')
  });
  ngOnInit() {
  }

  addStockExchange() {
    let userInput: any = {
      stockExchange: this.addStockExchangeForm.get('stockExchange').value,
      brief: this.addStockExchangeForm.get('brief').value,
      address: this.addStockExchangeForm.get('address').value,
      remarks: this.addStockExchangeForm.get('remarks').value,
    };
    this.stockexchangeService.addNewStockExchang(userInput).subscribe(
      resp => {
        if (resp === 'successful') {
          this.isShow = true;
        }
      });
  }

}
// n