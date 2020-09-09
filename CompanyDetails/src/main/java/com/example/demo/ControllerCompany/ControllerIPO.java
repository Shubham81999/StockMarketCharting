package com.example.demo.ControllerCompany;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.DTO.IpoDTO;
import com.example.demo.entity.CompanyEnfo;
import com.example.demo.entity.IPODetails;
import com.example.demo.service.IpoService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/ipo")
public class ControllerIPO {
	
	@Autowired
	private IpoService ipoService;
	
	@GetMapping("/getipo/{companyid}")
	public ResponseEntity<List<IpoDTO>> viewAllIpo(@PathVariable Long companyid)
	{
		return new ResponseEntity<List<IpoDTO>>(ipoService.getCompanyIPODetails(companyid),HttpStatus.FOUND);
	}
	@PutMapping("/updateipo/")
	public ResponseEntity<IpoDTO> updateCompany(@RequestBody IpoDTO ipoDTO) throws Exception
	{
		return new ResponseEntity<IpoDTO>(ipoService.updateIPODetails(ipoDTO),HttpStatus.CREATED);
	}
}
