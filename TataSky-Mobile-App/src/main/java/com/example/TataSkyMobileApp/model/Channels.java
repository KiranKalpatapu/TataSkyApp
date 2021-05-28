package com.example.TataSkyMobileApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Channels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int channelNo;
	private String channelName;
	@ManyToOne
	@JsonIgnore
	private Recharge recharge;
	@ManyToOne
	@JsonIgnore
	private Pack pack;
	
	
	public int getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(int channelNo) {
		this.channelNo = channelNo;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Recharge getRecharge() {
		return recharge;
	}
	public void setRecharge(Recharge recharge) {
		this.recharge = recharge;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	

}
