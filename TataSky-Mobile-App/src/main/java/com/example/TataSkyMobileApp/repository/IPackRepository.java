package com.example.TataSkyMobileApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TataSkyMobileApp.model.Pack;

public interface IPackRepository extends JpaRepository<Pack, Long>{
	
	public List<Pack> findPacksByCostGreaterThan(double cost);
	
//	public List<Pack> getPacksByCost();
	
//	public List<Pack> findPackOrderBydaysValidityAsc(); 

//	public List<Pack> popularPacks();
}
