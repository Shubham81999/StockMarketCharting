package com.example.demo.service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.example.demo.DAOclass.CompanyEnfoDAO;
import com.example.demo.DAOclass.StockPriceDAO;
import com.example.demo.DTO.CompanyDTO;
import com.example.demo.DTO.IpoDTO;
import com.example.demo.DTO.StockPriceDTO;
import com.example.demo.entity.CompanyEnfo;
import com.example.demo.entity.IPODetails;
import com.example.demo.entity.StockPriceEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service

@NoArgsConstructor
@AllArgsConstructor
public class CompanyService {
	
	@Autowired
	private CompanyEnfoDAO companyEnfoDAO;

	
	@Transactional
	public CompanyDTO addCompany(CompanyEnfo companyEnfo)
	{
		companyEnfoDAO.save(companyEnfo);
		ModelMapper mapper = new ModelMapper();
		CompanyDTO companyDTO = mapper.map(companyEnfo, CompanyDTO.class);
		return companyDTO;
	}
	
	@Transactional
	public List<CompanyDTO> getCompanyDetails()
	{
		List<CompanyEnfo> companyList = companyEnfoDAO.findAll();
		ModelMapper mapper = new ModelMapper();
		Type list = new TypeToken<List<CompanyDTO>>() {}.getType();
		List<CompanyDTO> companyDtoList = mapper.map(companyList, list);
		return companyDtoList;
	}
	
	@Transactional
	public CompanyDTO updateCompanyEnfo(CompanyDTO companyDTO,String companyName)
	{	
		ModelMapper mapper = new ModelMapper();
		CompanyEnfo companyEnfo1 = mapper.map(companyDTO, CompanyEnfo.class);
		CompanyEnfo companyEnfo = companyEnfoDAO.findByCompanyName(companyName);
		companyEnfo1.setId(companyEnfo.getId());
		companyEnfoDAO.save(companyEnfo1);
		return companyDTO;
	}
	
	@Transactional
	public CompanyDTO removeCompany(String companyName)
	{
		CompanyEnfo companyEnfo = companyEnfoDAO.findByCompanyName(companyName);
		ModelMapper mapper = new ModelMapper();
		CompanyDTO companyDTO = mapper.map(companyEnfo, CompanyDTO.class);
		companyEnfoDAO.delete(companyEnfo);
		return companyDTO;
	}
	@Transactional
	public List<CompanyDTO> getMatchingCompanies(String companyName)
	{
		ModelMapper mapper = new ModelMapper();
		List<CompanyEnfo> companyEnfo = companyEnfoDAO.findCompanyWithPartOfName(companyName);
		Type list = new TypeToken<List<CompanyDTO>>() {}.getType();
		List<CompanyDTO> companyDTO = mapper.map(companyEnfo, list);
		return companyDTO;
	}
//	@Transactional
//	public CompanyDTO getByCompanyName(String companyName)
//	{
//		CompanyEnfo companyEnfo = companyEnfoDAO.findByCompanyName(companyName);
//		ModelMapper mapper = new ModelMapper();
//		CompanyDTO companyDTO = mapper.map(companyEnfo, CompanyDTO.class);
//		return companyDTO;	
//	}
	@Transactional
	public List<StockPriceDTO> getCompanyStockPrice(LocalDate fperiod,LocalDate tperiod)
	{	
		ModelMapper mapper = new ModelMapper();
		List<StockPriceEntity> stockPriceEntity = companyEnfoDAO.getCompanyStockPrice(fperiod, tperiod);
		Type list = new TypeToken<List<StockPriceDTO>>() {}.getType();
		List<StockPriceDTO> stockPriceDTO = mapper.map(stockPriceEntity, list);
		return stockPriceDTO;	
	}
	@Transactional
	public CompanyDTO getCompanyByID(Long companyid)
	{
		ModelMapper mapper = new ModelMapper();
		CompanyEnfo companyEnfo = companyEnfoDAO.findById(companyid).orElse(null);
		if(companyEnfo.equals(null))
		{
			return null;
		}
		CompanyDTO companyDTO = mapper.map(companyEnfo, CompanyDTO.class);
		return companyDTO;		
	}
}
