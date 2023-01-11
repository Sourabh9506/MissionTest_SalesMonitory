package com.nissan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.dao.SalesVisitDao;
import com.nissan.model.SalesVisit;

@Service
@Transactional
public class SalesVisitImpl implements SalesVisitService{
	
	@Autowired
	private SalesVisitDao salesVisitDao;

	@Override
	public APIResponse getAllSalesVisitDetails() {
		APIResponse apiResponse = new APIResponse();
		List<SalesVisit> salesList=salesVisitDao.findAll();
		
		if(salesList.isEmpty()) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setData("Database is empty");
		}else {
			apiResponse.setData(salesList);
		}
		
		return apiResponse;
	}

	@Override
	public APIResponse findSalesVisitDetailsById(Integer id) {
		APIResponse apiResponse = new APIResponse();
        
		SalesVisit salesVisit=salesVisitDao.findById(id).orElse(null);
		
		if(salesVisit==null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("User Not Found");
			
		}else {
			Map<String,Object> data=new HashMap<>();
			data.put("Id",salesVisit.getVisit_id());
			data.put("Name", salesVisit.getCust_name());
			apiResponse.setData(data);
		}
		
		return apiResponse;
	}

	@Override
	public APIResponse addSalesVisitDetails(SalesVisit salesVisit,Integer visit_id) {
		APIResponse apiResponse = new APIResponse();
//		try {
//			detailsValidation(salesVisit);
//		}catch(SalesVisitException e) {
//			apiResponse.setStatus(HttpStatus.CONFLICT.value());
//		    apiResponse.setError(e.getMessage());
//		    return apiResponse;
//		}
		SalesVisit newVisit=new SalesVisit(salesVisit.getVisit_id(),salesVisit.getCust_name());
        
		apiResponse.setData("User Details saved successfully");
		
		return apiResponse;
	}

	@Override
	public APIResponse deleteSalesVisitDetailsById(Integer id) {
		APIResponse apiResponse = new APIResponse();
		
		SalesVisit deleteVisit=salesVisitDao.findById(id).orElse(null);
		
		if(deleteVisit==null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setData("User Not Found");
		}

		return apiResponse;
	}

	@Override
	public APIResponse updateSalesVisitDetailsById(SalesVisit salesVisit, Integer id) {
		APIResponse apiResponse= new APIResponse();
		
		SalesVisit updateVisit=salesVisitDao.findById(id).orElse(null);
		
		if(updateVisit==null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setData("User Not Found");
		}else {
			if(updateVisit.getVisit_id()!=null) {
				updateVisit.setVisit_id(salesVisit.getVisit_id());
			}
			if(updateVisit.getCust_name()!=null ) {
				updateVisit.setCust_name(salesVisit.getCust_name());
			}
			((CrudRepository<SalesVisit, Integer>) updateVisit).save(updateVisit);
			apiResponse.setData("Customer with id"+updateVisit.getVisit_id()+"and name "+updateVisit.getCust_name()+"is successfully updated ");
			
		}
		
		
		return apiResponse;
	}
	
	

}
