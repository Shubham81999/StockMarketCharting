package com.example.demo.entity;
import javax.persistence.JoinColumn;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CompanyInformation")
public class CompanyEnfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "Company_Name")
	@NotEmpty(message = "Company Name Cannot be NULL")
	private String companyName;
	@Column(name = "TurnOver")
	private long turnover;
	@Column(name = "CEO")
	private String ceo;
	@Column(name = "Board_Of_Directors")
	private String[] boardOfDirectors;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(
			  name = "Company_Stock", 
			  joinColumns = @JoinColumn(name = "companyInformation_id"), 
	  	  inverseJoinColumns = @JoinColumn(name = "stockExchange_id"))
	private List<StockExchange> stockExchange;
	
	@Column(name = "Sector")
	private String sectorId;
	@Column(name = "CompanyBrief")
	private String companybrief;
	@Column(name = "StockCode")
	private int stockCode;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<IPODetails> ipoDetails;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StockPriceEntity> stockPrice;
	
	
}
