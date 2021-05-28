

package com.example.TataSkyMobileApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.TataSkyMobileApp.model.Account;
import com.example.TataSkyMobileApp.model.Channels;
import com.example.TataSkyMobileApp.model.Pack;
import com.example.TataSkyMobileApp.model.Recharge;
import com.example.TataSkyMobileApp.model.ServiceRequest;
import com.example.TataSkyMobileApp.model.User;
import com.example.TataSkyMobileApp.repository.IAccountRepository;
import com.example.TataSkyMobileApp.repository.IChannelsRepository;
import com.example.TataSkyMobileApp.repository.IPackRepository;
import com.example.TataSkyMobileApp.repository.IRechargeRepository;
import com.example.TataSkyMobileApp.repository.IServiceRequestRepository;
//import com.example.TataSkyMobileApp.repository.IPackRepository;
//import com.example.TataSkyMobileApp.repository.IRechargeRepository;
//import com.example.TataSkyMobileApp.repository.IServiceRequestRepository;
import com.example.TataSkyMobileApp.repository.IUserRepository;

@SpringBootApplication
public class TataSkyMobileAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TataSkyMobileAppApplication.class, args);
			
	}
}