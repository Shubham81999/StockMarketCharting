package com.example.demo.DAO;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.model.CompanyEnfo;
import com.example.demo.model.StockExchange;


@Repository
public interface CompanyEnfoDAO extends JpaRepository<CompanyEnfo,Long>{


	
	
	@Query("SELECT u.companyName FROM StockExchange u WHERE u.stockExchange = :stockExchange")
	List<String> getCompaniesList(@Param("stockExchange") String stockExchange);
	
	@Query("SELECT u FROM StockExchange u")
	List<StockExchange> getallStockExchange();
}
