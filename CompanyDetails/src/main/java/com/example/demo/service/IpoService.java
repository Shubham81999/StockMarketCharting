package com.example.demo.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAOclass.CompanyEnfoDAO;
import com.example.demo.DAOclass.IPODetailsDAO;
import com.example.demo.DTO.IpoDTO;
import com.example.demo.entity.CompanyEnfo;
import com.example.demo.entity.IPODetails;

import lombok.Data;

@Service
@Data
public class IpoService {
		
		@Autowired
		private IPODetailsDAO ipoDetailsDAO;
		@Autowired
		private CompanyEnfoDAO companyEnfoDAO;
		
		@Transactional
		public List<IpoDTO> getCompanyIPODetails(Long id)
		{
			ModelMapper mapper = new ModelMapper();
			CompanyEnfo companyEnfo = companyEnfoDAO.findById(id).orElse(null);
			List<IPODetails> ipoDetails = companyEnfo.getIpoDetails();
			Type list = new TypeToken<List<IpoDTO>>() {}.getType();
			List<IpoDTO> ipoDTO = mapper.map(ipoDetails, list);
			return ipoDTO;		
			
		}
		
		@Transactional
		public IpoDTO updateIPODetails(IpoDTO ipoDTO)
		{
			ModelMapper mapper = new ModelMapper();
//			CompanyEnfo companyEnfo = companyEnfoDAO.findById(id).orElse(null);
//			Type list = new TypeToken<List<IPODetails>>() {}.getType();
			IPODetails ipoDetails = mapper.map(ipoDTO, IPODetails.class);
			ipoDetailsDAO.save(ipoDetails);
//			ipoDetails.setIpoDetails(ipoDetails);
//			companyEnfoDAO.save(companyEnfo);
			return ipoDTO;
		}
}
