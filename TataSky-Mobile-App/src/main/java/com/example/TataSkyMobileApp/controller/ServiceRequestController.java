package com.example.TataSkyMobileApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.TataSkyMobileApp.exception.ServiceRequestException;
import com.example.TataSkyMobileApp.model.Account;
import com.example.TataSkyMobileApp.model.ServiceRequest;
import com.example.TataSkyMobileApp.service.ServiceRequestService;

@RestController
@RequestMapping("/ServiceReq")

@CrossOrigin
public class ServiceRequestController {
	
	@Autowired
	ServiceRequestService service;
	
	@PostMapping("/saveReq")
	public ServiceRequest saveRequest(@RequestBody Account account) throws ServiceRequestException{
		
		return service.addRequest(account);
	}
	
	@PutMapping("/openReq")
	public  ServiceRequest openRequest(@RequestBody Account account) throws ServiceRequestException
	{
		return service.openedServiceRequest(account);
	}

}
