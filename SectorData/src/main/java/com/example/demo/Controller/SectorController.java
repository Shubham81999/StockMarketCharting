package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ServiceSector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/sectorcompany")
public class SectorController {
		
	
	ServiceSector serviceSector;
	
	@GetMapping("/companylist")
	public ResponseEntity<List<String>> getCompanyList(@RequestParam("sector") String sector)
	{
		return new ResponseEntity<List<String>>(serviceSector.getSectorCompanies(sector),HttpStatus.ACCEPTED);
	}
	
}
