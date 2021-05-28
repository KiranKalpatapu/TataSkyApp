package com.example.TataSkyMobileApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TataSkyMobileApp.exception.PackException;
import com.example.TataSkyMobileApp.model.Pack;
import com.example.TataSkyMobileApp.repository.IPackRepository;

@Service
public class PackService {
	
	@Autowired
	IPackRepository packRepository;
	
	public Pack add(Pack pack) throws PackException {
		Optional<Pack> findById = packRepository.findById(pack.getId());
		if(!findById.isPresent()) {
			 packRepository.save(pack);
			 return pack;
		}
		else	
			throw new PackException("Pack already exists");
	}
	
	public Pack update(Pack pack) throws PackException {
		Optional<Pack> findById = packRepository.findById(pack.getId());
		if(findById.isPresent()) {
		   pack.setCost(pack.getCost());
		   pack.setDaysValidity(pack.getDaysValidity());
		   pack.setPlanName(pack.getPlanName());
		   pack.setDescription(pack.getDescription());
		   pack.setChannel(pack.getChannel());
		   pack.setAcc(pack.getAcc());
		   packRepository.save(pack);
		   return pack;
		}
		else
			throw new PackException("Pack does not exist");
	}
	
	public Pack findById(Long id) throws PackException {
		Optional<Pack> find = packRepository.findById(id);
		if(find.isPresent()) {
			return packRepository.findById(id).get();
		}
		else
			throw new PackException("Pack does not exist");
	}
	
	public List<Pack> getPacksGreaterThan(double amount) throws PackException {
		return packRepository.findPacksByCostGreaterThan(amount);
	}
	
//	public List<Pack> findPacksInAscendingOrderByCost() throws PackException {
//		
//	}
//	
//	public List<Pack> findPacksInAscendingOrderByDaysValidity() throws PackException {
//		
//	}
//	
//	public List<Pack> popularPacks() throws PackException {
//			
//	}
	
	public void deleteByPackId(Long packId) throws PackException {
		Optional<Pack> find=packRepository.findById(packId);
		if(find.isPresent())
		{
			packRepository.deleteById(packId);
		}
		else
			throw new PackException("Pack does not exist");
	}


}
