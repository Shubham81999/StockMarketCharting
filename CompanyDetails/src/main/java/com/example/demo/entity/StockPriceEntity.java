package com.example.demo.entity;


import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "StockPriceEntity")
public class StockPriceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name= "companyName")
	private String companyName;
	@Column(name = "Current_Price")
	private Long currentPrice;
	@Column(name = "Time")
	private LocalTime time;
	@Column(name = "Date")
//	@Temporal(TemporalType.DATE)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") 
	private LocalDate date;
}
