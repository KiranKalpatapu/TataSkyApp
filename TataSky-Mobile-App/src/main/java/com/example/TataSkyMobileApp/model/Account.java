package com.example.TataSkyMobileApp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long accountId;
	@OneToOne(mappedBy="account",cascade=CascadeType.ALL)
	//@JsonIgnore
	private User user;
	@OneToMany(mappedBy="account",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
    private List<Recharge> recharges;
    private LocalDate registeredDate;
    @OneToMany(mappedBy="account",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonIgnore
    private List<ServiceRequest> requests;
    @ManyToOne //(cascade=CascadeType.ALL)
    private Pack currentPack;
	
    
    
    public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	  public User getUser() {
		  return user;
		  }
	  public void setUser(User user) {
	  this.user = user; 
	  }
	  public List<Recharge> getRecharges() {
		  return recharges;
	  } 
	  public void setRecharges(List<Recharge> recharges) 
	  { 
		  this.recharges = recharges;
	  } 
	  public LocalDate getRegisteredDate() { 
		  return registeredDate; 
		  }
	  public void setRegisteredDate(LocalDate registeredDate) { 
		  this.registeredDate = registeredDate;
		  }
	  public List<ServiceRequest> getRequests() {
		  return requests;
		  }
	  public void setRequests(List<ServiceRequest> requests) {
	      this.requests = requests;
	  }
	  public Pack getCurrentPack() { 
		  return currentPack; 
		  } 
	  public void setCurrentPack(Pack currentPack) {
	  this.currentPack = currentPack; 
	  }
	  
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + "]";
	}
 
}
