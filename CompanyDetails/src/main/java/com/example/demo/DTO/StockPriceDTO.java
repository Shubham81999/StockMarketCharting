package com.example.demo.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDTO {
	
	private Long id;
	private String companyName;
	private Long currentPrice;
	private LocalTime time;
	private LocalDate date;

}
