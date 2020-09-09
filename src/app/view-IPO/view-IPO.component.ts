import { Component, OnInit } from '@angular/core';
import { ComanyService } from '../../services/comany.service'
import { IPO } from 'src/model/IPO';

@Component({
  selector: 'app-view-IPO',
  templateUrl: './view-IPO.component.html',
  styleUrls: ['./view-IPO.component.css']
})
export class ViewIPOComponent implements OnInit {

  constructor(private companyService: ComanyService) { }
  ipoList: IPO[];
  ngOnInit() {
    this.getIPOList();
  }

  getIPOList(): void {
    this.companyService.getAllIPOs().subscribe(
      (data) => {
        this.ipoList = data;
      }
    );
  }
}
// n