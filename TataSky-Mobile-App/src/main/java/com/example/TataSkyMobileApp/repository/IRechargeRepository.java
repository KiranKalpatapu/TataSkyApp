package com.example.TataSkyMobileApp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TataSkyMobileApp.model.Recharge;

@Repository
public interface IRechargeRepository extends JpaRepository<Recharge,Long>{

	public List<Recharge> findByDaysValidityBetween(LocalDate startDate, LocalDate endDate);

}
