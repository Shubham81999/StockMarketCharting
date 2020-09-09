package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockExchangeDTO {

	private Long id;
	private String companyName;
	private String stockExchange;
	private String breif;
	private String contactAddress;
	private String remarks;
	
	
}
