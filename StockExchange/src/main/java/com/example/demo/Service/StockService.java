package com.example.demo.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CompanyEnfoDAO;
import com.example.demo.DAO.StockExchangeDAO;

import com.example.demo.DTO.CompanyEnfoDTO;
import com.example.demo.DTO.StockExchangeDTO;
import com.example.demo.model.StockExchange;

import org.modelmapper.TypeToken;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockService {

		@Autowired
		StockExchangeDAO stockExchangeDAO;
		@Autowired
		CompanyEnfoDAO companyEnfoDAO;
		@PersistenceContext
	    private EntityManager entityManager;
		Random random = new Random();

		
		@Transactional
		public  StockExchangeDTO addStockExchange(StockExchange stockExchange)
		{
			entityManager.createNativeQuery("INSERT INTO stock_exchange (id,Stock_Exchange, Brief,Contact_Address,Remarks) VALUES (?,?,?,?,?)")
			  .setParameter(1, random.nextInt(10000))
			  .setParameter(2, stockExchange.getStockExchange())
		      .setParameter(3, stockExchange.getBreif())
		      .setParameter(4, stockExchange.getContactAddress())
		      .setParameter(5, stockExchange.getRemarks())
		      .executeUpdate();
			ModelMapper mapper = new ModelMapper();
			StockExchangeDTO stockExchangeDTO = mapper.map(stockExchange, StockExchangeDTO.class);
			return stockExchangeDTO;
		}
		@Transactional
		public List<StockExchangeDTO> getStockExchangesList()
		{
			List<StockExchange> stockExchange = companyEnfoDAO.getallStockExchange();
			ModelMapper mapper = new ModelMapper();
			Type list = new TypeToken<List<StockExchangeDTO>>() {}.getType();
			List<StockExchangeDTO> stockExchangeDTO = mapper.map(stockExchange, list);
			return stockExchangeDTO;
		}
		@Transactional
		public List<String> getCompaniesStock(String stockExchange)
		{
			List<String> companyList = companyEnfoDAO.getCompaniesList(stockExchange);
			return companyList;
		}
}
