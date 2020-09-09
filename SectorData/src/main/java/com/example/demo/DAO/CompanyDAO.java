package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modal.CompanyEnfo;

public interface CompanyDAO extends JpaRepository<CompanyEnfo,Long> {
	
	@Query("SELECT u.companyName FROM CompanyEnfo u WHERE u.sector = :sector")
	List<String> getCompaniesList(@Param("sector") String sector);
	
	

}
