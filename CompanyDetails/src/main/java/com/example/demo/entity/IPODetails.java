package com.example.demo.entity;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IpoDetails")
public class IPODetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "Price_per_share")
	private Long pricePerShare;
	@Column(name= "companyName")
	private String companyName;
	@Column(name = "Total_number_of_Shares")
	private Long totalNoShares;
	//@Column(name = "Open_Date_Time")
	//private LocalDateTime openDateTime;
	@Column(name = "Remarks")
	private String remarks;
//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinTable(
//			  name = "Company_IPO", 
//			  joinColumns = @JoinColumn(name = "ipoDetails_id"), 
//			  inverseJoinColumns = @JoinColumn(name = "companyInformation_id"))
//	private CompanyEnfo company;
}
