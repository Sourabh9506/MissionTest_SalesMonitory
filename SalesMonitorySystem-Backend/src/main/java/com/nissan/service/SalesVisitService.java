package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.model.SalesVisit;

public interface SalesVisitService {
	
	// get all sales visit details
	APIResponse getAllSalesVisitDetails();
	
	APIResponse findSalesVisitDetailsById(Integer id);
	
	APIResponse addSalesVisitDetails(SalesVisit salesVisit,Integer visit_id);
	
	APIResponse deleteSalesVisitDetailsById(Integer id);
	
	APIResponse updateSalesVisitDetailsById(SalesVisit salesVisit,Integer id);
	

}
