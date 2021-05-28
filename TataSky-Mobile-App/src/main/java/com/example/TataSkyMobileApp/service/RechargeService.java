package com.example.TataSkyMobileApp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TataSkyMobileApp.exception.RechargeException;
import com.example.TataSkyMobileApp.model.Recharge;
import com.example.TataSkyMobileApp.repository.IRechargeRepository;


	@Service
	public class RechargeService {
		@Autowired
		IRechargeRepository rechargeRepository;

//		public Recharge createRecharge(Account account,Pack pack) throws RechargeException {
//			
//		}
		
		public Recharge update(Recharge recharge) throws RechargeException {
			Optional<Recharge> find=rechargeRepository.findById(recharge.getId());
			if(find.isPresent())
			{
			recharge.setAccount(recharge.getAccount());
			recharge.setAmount(recharge.getAmount());
			recharge.setChannel(recharge.getChannel());
			recharge.setDaysValidity(recharge.getDaysValidity());
			recharge.setPlanDescription(recharge.getPlanDescription());
			recharge.setPlanName(recharge.getPlanName());
			recharge.setPurchasedDate(recharge.getPurchasedDate());
			rechargeRepository.save(recharge);
			return recharge;
		    }	
			else
				throw new RechargeException("Recharge does not exit");
			}
		
		public List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate)
		{
			return rechargeRepository.findByDaysValidityBetween(startDate, endDate);
			
		}
		
//		public long countRechargesInPeriod(LocalDate startDate, LocalDate endDate)
//		{
//			return rechargeRepository.countByDaysValidityBetween(startDate, endDate);
//			
//		}
//		public  double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate)
//		{
//			return rechargeRepository.totalRevenueInPeriod(startDate, endDate);
//		}
		

	}
