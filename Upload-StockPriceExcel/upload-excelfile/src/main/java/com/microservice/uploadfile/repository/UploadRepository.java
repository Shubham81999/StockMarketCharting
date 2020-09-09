package com.microservice.uploadfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microservice.uploadfile.model.StockPrice;

@Repository
public interface UploadRepository extends JpaRepository<StockPrice, Integer>{

}
