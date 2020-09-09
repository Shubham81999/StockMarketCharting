package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEnfoDTO {

	private Long id;
	private String companyName;
	private long turnover;
	private String ceo;
	private String[] boardOfDirectors;
	private String sectorId;
	private String companybrief;
	private int stockCode;	
	
	
}
