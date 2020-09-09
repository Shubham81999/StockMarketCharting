import { Component, OnInit, ElementRef } from '@angular/core';
import { UploadExcelService } from '../../services/upload-excel.service';
import { FileUploadResult } from '../../model/FileUploadResult';

@Component({
  selector: 'app-upload-excel',
  templateUrl: './upload-excel.component.html',
  styleUrls: ['./upload-excel.component.css']
})
export class UploadExcelComponent implements OnInit {

  constructor(private el: ElementRef, private uploadService: UploadExcelService) { }
  fileUploadResult: FileUploadResult;
  isShow = false;
  ngOnInit() {
  }

  uploadExcel() {
    let t_files: any = this.el.nativeElement.querySelector('#file').files[0];
    this.uploadService.fileUpload(t_files).subscribe(
      data => {
        if (data != null) {
          this.isShow = true;
          this.fileUploadResult = data;
        }
      });
  }

}
// n