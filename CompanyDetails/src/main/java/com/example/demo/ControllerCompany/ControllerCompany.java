package com.example.demo.ControllerCompany;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CompanyDTO;
import com.example.demo.DTO.IpoDTO;
import com.example.demo.DTO.StockPriceDTO;
import com.example.demo.entity.CompanyEnfo;
import com.example.demo.service.CompanyService;
import com.example.demo.service.IpoService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@RestController
@RequestMapping("/company")
@NoArgsConstructor
@AllArgsConstructor
public class ControllerCompany {
	
	@Autowired
	CompanyService companyService;
	IpoService ipoService;
	
	@GetMapping("/allcompany")
	public ResponseEntity<List<CompanyDTO>> allCompanyEnfo()
	{
		return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyDetails());
	}
	@PostMapping("/addcompany")
	public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyEnfo companyEnfo) throws InvalidObjectException
	{	
		return new ResponseEntity<CompanyDTO>(companyService.addCompany(companyEnfo),HttpStatus.CREATED);
	}
	@PostMapping("/updatecompany/{companyName}")
	public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO,@PathVariable String companyName) throws Exception
	{
		return new ResponseEntity<CompanyDTO>(companyService.updateCompanyEnfo(companyDTO, companyName),HttpStatus.CREATED);
	}
	@GetMapping("/getmatchingcompany/{companyName}")
	public ResponseEntity<List<CompanyDTO>> getMatchingCompany(@PathVariable String companyName)
	{
		return new ResponseEntity<List<CompanyDTO>>(companyService.getMatchingCompanies(companyName),HttpStatus.FOUND);
	}
	@DeleteMapping("/deletecompany/{companyName}")
	public ResponseEntity<CompanyDTO> removeCompany(@PathVariable String companyName)
	{
		return new ResponseEntity<CompanyDTO>(companyService.removeCompany(companyName),HttpStatus.OK);
	}
	@GetMapping("/getcompanystockprice")
	public ResponseEntity<List<StockPriceDTO>> getCompanyStockPrice(@RequestParam("fperiod") String fperiod,@RequestParam("tperiod") String tperiod)
	{	
		
		return new ResponseEntity<List<StockPriceDTO>>(companyService.getCompanyStockPrice(LocalDate.parse(fperiod),LocalDate.parse(tperiod)),HttpStatus.OK);
	}
//	@GetMapping("/get/{companyName}")
//	public ResponseEntity<CompanyDTO> getnameCompany(@PathVariable String companyName)
//	{
//		return new ResponseEntity<CompanyDTO>(companyService.getByCompanyName(companyName),HttpStatus.FOUND);
//	}
	@GetMapping("/getcompany/{companyid}")
	public ResponseEntity<CompanyDTO> getCompanybyId(@PathVariable Long companyid)
	{	
		
		CompanyDTO company = companyService.getCompanyByID(companyid);
		if(company.equals(null))
		{
			return null;
		}
		return new ResponseEntity<CompanyDTO>(companyService.getCompanyByID(companyid),HttpStatus.FOUND);
	}
}
