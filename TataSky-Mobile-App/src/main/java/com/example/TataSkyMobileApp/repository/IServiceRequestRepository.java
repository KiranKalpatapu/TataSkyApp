package com.example.TataSkyMobileApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TataSkyMobileApp.model.ServiceRequest;

@Repository
public interface IServiceRequestRepository extends JpaRepository<ServiceRequest,Long> {

}
