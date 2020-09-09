package com.microservice.uploadfile.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microservice.uploadfile.helper.ExcelHelper;
import com.microservice.uploadfile.model.StockPrice;
import com.microservice.uploadfile.repository.UploadRepository;

@Service
public class UploadService {

	@Autowired
	private UploadRepository repo;
	
	public void save(MultipartFile file) {
		try {
			List<StockPrice> data = ExcelHelper.excelToData(file.getInputStream());
			System.out.println(data);
			repo.saveAll(data);
			System.out.println("saved");
		} catch(IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
}
