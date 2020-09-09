import { Component, OnInit } from '@angular/core';
import { Stockexchange } from 'src/model/stockexchange';
import { StockexchangeService } from '../../services/stockexchange.service'

@Component({
  selector: 'app-stockexchange-list',
  templateUrl: './stockexchange-list.component.html',
  styleUrls: ['./stockexchange-list.component.css']
})
export class StockexchangeListComponent implements OnInit {
  stockExchangeList: Stockexchange[];
  constructor(private stockexchangeService: StockexchangeService) { }

  ngOnInit() {
    this.getStockExchangeList();
  }

  getStockExchangeList(): void {
    this.stockexchangeService.getAllStockExchangs().subscribe(
      (data) => {
        this.stockExchangeList = data;
      }
    );
  }

}
// n