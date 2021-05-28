package com.example.TataSkyMobileApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private double cost;
    private int daysValidity;
    private String description;
    private String planName;
    @OneToMany(mappedBy="currentPack",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Account> acc;
    @OneToMany(mappedBy="pack",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Channels> channel;
    
   
	public List<Channels> getChannel() {
		return channel;
	}
	public void setChannel(List<Channels> channel) {
		this.channel = channel;
	}
	public List<Account> getAcc() {
		return acc;
	}
	public void setAcc(List<Account> acc) {
		this.acc = acc;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public int getDaysValidity() {
		return daysValidity;
	}
	public void setDaysValidity(Integer daysValidity) {
		this.daysValidity = daysValidity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}

	

}
