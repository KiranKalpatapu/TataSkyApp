package com.example.TataSkyMobileApp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="serviceRequest")
public class ServiceRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private LocalDate requestedDate;
	@ManyToOne
	private Account account;
	private String message;
	private boolean statusOpened;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatusOpened() {
		return statusOpened;
	}
	public void setStatusOpened(boolean statusOpened) {
		this.statusOpened = statusOpened;
	}
	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", message=" + message + ", statusOpened=" + statusOpened + "]";
	}
	
	

}
