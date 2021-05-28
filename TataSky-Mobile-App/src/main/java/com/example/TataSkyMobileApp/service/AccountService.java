package com.example.TataSkyMobileApp.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TataSkyMobileApp.exception.AccountException;
import com.example.TataSkyMobileApp.exception.UserException;
import com.example.TataSkyMobileApp.model.Account;
import com.example.TataSkyMobileApp.model.Pack;
import com.example.TataSkyMobileApp.model.User;
import com.example.TataSkyMobileApp.repository.IAccountRepository;
import com.example.TataSkyMobileApp.repository.IUserRepository;

@Service
public class AccountService {
	
	@Autowired
	IUserRepository userRepository;
	@Autowired
	IAccountRepository accountRepository;
	
	 public Account add(Account account) throws AccountException {
		Optional<Account> findById = accountRepository.findById(account.getAccountId());
		if(!findById.isPresent()) {
			 accountRepository.save(account);
			 return account;
		}
		else	
			throw new AccountException("Account already exists");
	}
	
	public Account update(Account account) throws AccountException {
		Optional<Account> findById = accountRepository.findById(account.getAccountId());
		if(findById.isPresent()) {
		   account.setCurrentPack(account.getCurrentPack());
		   account.setRecharges(account.getRecharges());
		   account.setRequests(account.getRequests());
		   accountRepository.save(account);	
		   return account;
		}
		else
			throw new AccountException("Account does not exist");
	}
	
	public Account findById(Long accountId) throws AccountException {
		Optional<Account> find = accountRepository.findById(accountId);
		if(find.isPresent()) {
			return accountRepository.findById(accountId).get();
		}
		else
			throw new AccountException("Account does not exist");
	}
	
	@Transactional
	public void deleteByAccountId(Long accountId) throws AccountException {
		Optional<Account> find=accountRepository.findById(accountId);
		if(find.isPresent()) {
			accountRepository.deleteByAccountId(accountId);
	    }
		else
			throw new AccountException("Account does not exist");
	}
	
	public long countByRegisteredDateBetween(LocalDate startDate, LocalDate endDate) throws AccountException {
		return accountRepository.countByRegisteredDateBetween(startDate, endDate);
	}
	
	public long countAccounts() throws AccountException {
		return accountRepository.count();
	}
	
	//removePackForAccount(Account account, Pack pack)
//	public void removePackForAccount(Account account, Pack pack) throws AccountException {
//		
//	}
	
}
