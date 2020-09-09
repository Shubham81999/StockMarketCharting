package com.example.demo.DAOclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StockExchange;

@Repository
public interface StockExchangeDAO extends JpaRepository<StockExchange, Long> {

}
