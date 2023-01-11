
package com.nissan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.SalesVisit;
import com.nissan.service.SalesVisitService;

@CrossOrigin
@RestController
@RequestMapping("/api/sales")
public class SalesVisitController {
	
//	@SuppressWarnings("unused")
	@Autowired
	private SalesVisitService salesService;
	
	private APIResponse apiResponse;
	
	//get all details of customers
	@GetMapping
	public ResponseEntity<APIResponse> getAllSalesVisitDetails(){
		apiResponse=salesService.getAllSalesVisitDetails();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	// get customer by id
	@GetMapping("{id}")
	public ResponseEntity<APIResponse> findSalesVisitDetailsById(@PathVariable Integer id){
		apiResponse=salesService.findSalesVisitDetailsById(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	//post details of customer
	@PostMapping
	public ResponseEntity<APIResponse> addSalesVisitDetails(@RequestBody SalesVisit salesVisit, @PathVariable Integer id){
		apiResponse=salesService.addSalesVisitDetails(salesVisit,id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// update details of a user
	@PutMapping("{id}")
	public ResponseEntity<APIResponse> updateSalesVisitDetailsById(@RequestBody SalesVisit salesVisit,@PathVariable Integer id){
		apiResponse=salesService.updateSalesVisitDetailsById(salesVisit,id);
			
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	

}
