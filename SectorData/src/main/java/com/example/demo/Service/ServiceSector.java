package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.DAO.CompanyDAO;
import com.example.demo.DAO.SectorDAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceSector {
	
	
	CompanyDAO companyDAO;
	
	@Transactional
	public List<String> getSectorCompanies(String sector)
	{
		List<String> companyList = companyDAO.getCompaniesList(sector);
		return companyList;
	}
}
