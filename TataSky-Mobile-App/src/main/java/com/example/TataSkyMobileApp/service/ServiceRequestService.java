package com.example.TataSkyMobileApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TataSkyMobileApp.exception.ServiceRequestException;
import com.example.TataSkyMobileApp.model.Account;
import com.example.TataSkyMobileApp.model.ServiceRequest;
import com.example.TataSkyMobileApp.repository.IServiceRequestRepository;

@Service
public class ServiceRequestService {
	
	@Autowired
	IServiceRequestRepository serviceRequestRepository;
	
	public ServiceRequest addRequest(Account account) throws ServiceRequestException {
		long a=account.getAccountId();
		ServiceRequest find=serviceRequestRepository.getById(a);
		if(find.isStatusOpened()==false)
		{
			serviceRequestRepository.save(find);
		   return find;
		}
		else
			throw new ServiceRequestException("Request already exists");
	}

	public ServiceRequest openedServiceRequest(Account account)
	{
		return null;
	}
	
}
