package com.example.demo.DAOclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IPODetails;

@Repository
public interface IPODetailsDAO extends JpaRepository<IPODetails,Long> {

}
