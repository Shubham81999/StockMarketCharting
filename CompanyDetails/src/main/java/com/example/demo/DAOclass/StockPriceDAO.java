package com.example.demo.DAOclass;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StockPriceEntity;

public interface StockPriceDAO extends JpaRepository<StockPriceEntity, Long>{

	
		
		
}
