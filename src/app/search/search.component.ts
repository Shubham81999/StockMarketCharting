import { Component, OnInit, Output, EventEmitter,ElementRef } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  @Output() searchTrigger = new EventEmitter();
  constructor(private el: ElementRef) { }

  ngOnInit() {
  }

  onSearch() {
    let searchStr = this.el.nativeElement.querySelector('#search').value;
    this.searchTrigger.emit(searchStr);
  }
}
// n