package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpoDTO {
	
	private Long id;
	private String companyName;
	private Long pricePerShare;
	private Long totalNoShares;
	private String remarks;

}
