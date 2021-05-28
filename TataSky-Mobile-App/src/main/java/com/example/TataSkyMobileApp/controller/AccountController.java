package com.example.TataSkyMobileApp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TataSkyMobileApp.exception.AccountException;
import com.example.TataSkyMobileApp.model.Account;
import com.example.TataSkyMobileApp.service.AccountService;

@RestController
@RequestMapping("/Account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/add")
	public Account add(@RequestBody Account account) throws AccountException {
		return service.add(account);
	}
	
	@PutMapping("/update/{id}")
	public Account update(@PathVariable Long id,@RequestBody Account account) throws AccountException {
		account.setAccountId(id);
		return service.update(account);
	}
	
	@GetMapping("/findById/{accountId}")
	public Account findById(@PathVariable Long accountId) throws AccountException {
		return service.findById(accountId);
	}
	
	@DeleteMapping("/deleteByAccId/{accountId}")
	public void deleteByAccountId(@PathVariable Long accountId) throws AccountException {
		service.deleteByAccountId(accountId);
	}
	
	@GetMapping("/countBtwDates/{one_date}/{two_date}")
	public long countByRegisteredDateBetween(@PathVariable(value = "one_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @PathVariable(value = "two_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) throws AccountException {
		return service.countByRegisteredDateBetween(startDate, endDate);
	}
	
	@GetMapping("/countAccounts")
	public long countAccounts() throws AccountException {
		return service.countAccounts();
	}
	
//	@DeleteMapping("/removePack")
//	public void removePackForAccount(Account account, Pack pack) throws AccountException {
//		
//	}

}
