package com.example.demo.Controller;

import java.io.InvalidObjectException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.DTO.StockExchangeDTO;
import com.example.demo.Service.StockService;

import com.example.demo.model.StockExchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RestController
@RequestMapping("/stockexchange")
@NoArgsConstructor
@AllArgsConstructor
public class StockController {
		
		@Autowired
		StockService stockService;
		
		@GetMapping("/all")
		public ResponseEntity<List<StockExchangeDTO>> allStockExchange()
		{
			return ResponseEntity.status(HttpStatus.OK).body(stockService.getStockExchangesList());
		}
		@PostMapping("/addstockexchange")
		public ResponseEntity<StockExchangeDTO> addCompany(@RequestBody StockExchange stockExchange) throws InvalidObjectException
		{	
			return new ResponseEntity<StockExchangeDTO>(stockService.addStockExchange(stockExchange),HttpStatus.CREATED);
		}
		@GetMapping("/companiesList")
		public ResponseEntity<List<String>> companiesList(@RequestParam("stockExchange") String stockExchange)
		{
			return new ResponseEntity<List<String>>(stockService.getCompaniesStock(stockExchange),HttpStatus.FOUND);
		}
}
