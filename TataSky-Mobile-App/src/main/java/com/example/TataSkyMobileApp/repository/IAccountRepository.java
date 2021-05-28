package com.example.TataSkyMobileApp.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TataSkyMobileApp.model.Account;
import com.example.TataSkyMobileApp.model.Pack;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long>{

	public void deleteByAccountId(long accountId);
	
	public long countByRegisteredDateBetween(LocalDate startDate, LocalDate endDate);
	
	//public void removePackForAccount(Account account, Pack pack);
	
}
