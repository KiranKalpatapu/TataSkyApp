package com.example.TataSkyMobileApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TataSkyMobileApp.exception.UserException;
import com.example.TataSkyMobileApp.model.Account;
import com.example.TataSkyMobileApp.model.User;
import com.example.TataSkyMobileApp.repository.IAccountRepository;
import com.example.TataSkyMobileApp.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	IUserRepository userRepository;
	@Autowired
	IAccountRepository accountRepository;
	
	public User register(User user) throws UserException {
		Optional<User> findById = userRepository.findById(user.getId());
		if(!findById.isPresent()) {
			 userRepository.save(user);
			 return user;
		}
		else	
			throw new UserException("User already exists");
	}
	
	public User update(User user) throws UserException {
		Optional<User> findById = userRepository.findById(user.getId());
		if(findById.isPresent()) {
		   user.setFirstname(user.getFirstname());
		   user.setLastname(user.getLastname());
		   user.setPassword(user.getPassword());
		   user.setRole(user.getRole());
		   userRepository.save(user);	
		   return user;
		}
		else
			throw new UserException("User does not exist");
	}
	
	public User findById(Long id) throws UserException {
		Optional<User> find = userRepository.findById(id);
		if(find.isPresent()) {
			return userRepository.findById(id).get();
		}
		else
			throw new UserException("User does not exist");
	}
	
	public User readByUsername(String username) throws UserException {
		return userRepository.readByUsername(username);
	}
	
	public void deleteByUserId(Long id) throws UserException {
		Optional<User> find = userRepository.findById(id);
		if(find.isPresent()) {
			User u=userRepository.getById(id);
			Account a=u.getAccount();
			accountRepository.deleteById(a.getAccountId());
		}
		else
			throw new UserException("User does not exist");
	}

}
