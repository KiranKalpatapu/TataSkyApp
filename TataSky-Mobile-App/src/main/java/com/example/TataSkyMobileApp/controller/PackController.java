package com.example.TataSkyMobileApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TataSkyMobileApp.exception.PackException;
import com.example.TataSkyMobileApp.model.Pack;
import com.example.TataSkyMobileApp.service.PackService;

@RestController
@RequestMapping("Pack")
public class PackController {
	
	@Autowired
     PackService service;
	
	@PostMapping("/add")
	public Pack add(@RequestBody Pack pack) throws PackException {
		return service.add(pack);
	}
	
	@PutMapping("/update")
	public Pack update(@RequestBody Pack pack) throws PackException {
		return service.update(pack);
	}
	
	@GetMapping("/findById")
	public Pack findById(Long id) throws PackException {
		return service.findById(id);
	}
	
	@GetMapping("/packsGreaterThan")
	public List<Pack> getPacksGreaterThan(double amount) throws PackException {
		return service.getPacksGreaterThan(amount);
	}

//	@GetMapping("/packAscCost")
//	public List<Pack> findPacksInAscendingOrderByCost() throws PackException {
//		return service.findPacksInAscendingOrderByCost();
//	}
//	
//	@GetMapping("/packAscValidity")
//	public List<Pack> findPacksInAscendingOrderByDaysValidity() throws PackException {
//		return service.findPacksInAscendingOrderByDaysValidity();
//	}
//	
//	@GetMapping("/popularPacks")
//	public List<Pack> popularPacks() throws PackException {
//		return service.popularPacks();
//	}
	
	@DeleteMapping("/deleteByPackId/{packId}")
	public void deleteByPackId(Long packId) throws PackException {
	    service.deleteByPackId(packId);
	}
}
