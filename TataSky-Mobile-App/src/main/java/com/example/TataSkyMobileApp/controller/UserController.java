package com.example.TataSkyMobileApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TataSkyMobileApp.exception.UserException;
import com.example.TataSkyMobileApp.model.User;
import com.example.TataSkyMobileApp.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/add")
	public User register(@RequestBody User user) throws UserException {
		return service.register(user);
	}
	
	@PutMapping("/update")
	public User update(@RequestBody User user) throws UserException {
		return service.update(user);
	}
	
	@GetMapping("/findById/{id}")
	public User findById(@PathVariable Long id) throws UserException {
		return service.findById(id);
	}
	
	@GetMapping("/findByUname/{username}")
	public User readByUsername(@PathVariable String username) throws UserException {
		return service.readByUsername(username);
	}
	
	@DeleteMapping("/deleteByUserId/{id}")
	public void deleteByUserId(@PathVariable Long id) throws UserException {
		service.deleteByUserId(id);
	}

}
