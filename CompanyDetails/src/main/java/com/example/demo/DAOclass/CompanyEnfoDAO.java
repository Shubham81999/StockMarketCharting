package com.example.demo.DAOclass;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CompanyEnfo;
import com.example.demo.entity.StockPriceEntity;


@Repository
public interface CompanyEnfoDAO extends JpaRepository<CompanyEnfo,Long> {
	
	@Query("SELECT u FROM CompanyEnfo u where u.companyName LIKE lower(CONCAT('%',:companyName,'%'))")
	public List<CompanyEnfo> findCompanyWithPartOfName(@Param("companyName") String companyName);
	
	@Query("SELECT u FROM CompanyEnfo u WHERE u.companyName = :companyName")
	CompanyEnfo findByCompanyName(@Param("companyName") String companyName);
	
	@Query("SELECT u FROM StockPriceEntity u WHERE u.date  BETWEEN :fperiod AND :tperiod")		
	List<StockPriceEntity> getCompanyStockPrice(@Param("fperiod") LocalDate fperiod,@Param("tperiod") LocalDate tperiod);

}
