package com.example.TataSkyMobileApp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recharge {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@ManyToOne
	@JsonIgnore
	private Account account;
    private double amount;
    private int daysValidity;
    private String planDescription;
    private String planName;
    private LocalDate purchasedDate;
    @OneToMany(mappedBy="recharge",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private List<Channels> channel;
    
    
	public List<Channels> getChannel() {
		return channel;
	}
	public void setChannel(List<Channels> channel) {
		this.channel = channel;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getDaysValidity() {
		return daysValidity;
	}
	public void setDaysValidity(int daysValidity) {
		this.daysValidity = daysValidity;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public LocalDate getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(LocalDate purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
//	public List<String> getChannels() {
//		return channels;
//	}
//	public void setChannels(List<String> channels) {
//		this.channels = channels;
//	}
	@Override
	public String toString() {
		return "Recharge [id=" + id + ", amount=" + amount + ", daysValidity=" + daysValidity + ", planDescription="
				+ planDescription + ", planName=" + planName + "]";
	}
	
	
}
