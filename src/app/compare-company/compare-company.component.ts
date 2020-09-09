import { Component, OnInit, ElementRef } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { ComanyService } from '../../services/comany.service'
import { Company } from 'src/model/company';

@Component({
  selector: 'app-compare-company',
  templateUrl: './compare-company.component.html',
  styleUrls: ['./compare-company.component.css']
})
export class CompareCompanyComponent implements OnInit {

  constructor(private companyService: ComanyService, private el: ElementRef) { }
  public chartOption;
  companyList: Company[];
  chartForm = new FormGroup({
    company1: new FormControl(''),
    company2: new FormControl(''),
    fromPeroid: new FormControl(''),
    toPeroid: new FormControl('')
  });
  selectedCompany1: string;
  selectedCompany2: string;

  ngOnInit() {
    this.getCompanyList();
  }
// n
  getCompanyList(): void {
    this.companyService.getAllCompanies().subscribe(
      (data) => {
        this.companyList = data;
      }
    );
  }

  onChange1($event) {
    this.selectedCompany1 = $event.target.options[$event.target.options.selectedIndex].text;
  }

  onChange2($event) {
    this.selectedCompany2 = $event.target.options[$event.target.options.selectedIndex].text;
  }

  compareData() {
    let companyName1 = this.selectedCompany1;
    let companyName2 = this.selectedCompany2;
    let userInput: any = {
      company1: this.chartForm.get('company1').value,
      company2: this.chartForm.get('company2').value,
      fromPeroid: this.chartForm.get('fromPeroid').value,
      toPeroid: this.chartForm.get('toPeroid').value,
    };
    this.companyService.compareCompany(userInput).subscribe(
      resp => {
        this.chartOption = {
          title: {
            text: 'stock price charts - company '
          },
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: [companyName1, companyName2]
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          toolbox: {
            feature: {
              saveAsImage: {}
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
          },
          yAxis: {
            type: 'value'
          },
          series: [
            {
              name: companyName1,
              type: 'line',
              stack: 'price',
              data: resp.company1Data
            },
            {
              name: companyName2,
              type: 'line',
              stack: 'price',
              data: resp.company2Data
            }
          ]
        };

      });
  }

}
