package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.SectorInfo;

public interface SectorDAO extends JpaRepository<SectorInfo,Long> {
	
		
}
