package com.microservice.uploadfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.microservice.uploadfile.model.Response;
import com.microservice.uploadfile.service.UploadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UploadController {

	@Autowired
	private UploadService uploadService;
	
	@PostMapping(value = "/uploadFile")
	public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file)
	{
		String message="";
		
	
			uploadService.save(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
		
		
	}
}
