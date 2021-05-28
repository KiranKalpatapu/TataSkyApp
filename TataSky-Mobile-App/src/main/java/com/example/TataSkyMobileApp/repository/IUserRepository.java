package com.example.TataSkyMobileApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TataSkyMobileApp.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
	
	@Query("from User where username=:x")
	public User readByUsername(@Param("x") String username);

}
