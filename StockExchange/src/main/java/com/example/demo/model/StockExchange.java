package com.example.demo.model;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.example.demo.model.CompanyEnfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Entity
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Table(name = "StockExchange")
	public class StockExchange {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@Column(name = "Company_Name")
		private String companyName;
		@Column(name = "Stock_Exchange")
		private String stockExchange;
		@Column(name = "Brief")
		private String breif;
		@Column(name = "Contact_Address")
		private String contactAddress;
		@Column(name = "Remarks")
		private String remarks;
//		@ManyToMany
//		@JoinTable(
//				  name = "StockExchange_Companies", 
//				  joinColumns = @JoinColumn(name = "stockExchange_id"), 
//		  	  inverseJoinColumns = @JoinColumn(name = "companyInformation_id"))
//		List<CompanyEnfo> companyEnfo;
}
