package com.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="data")
@SequenceGenerator(name="dataid",sequenceName="dbid",allocationSize=1)
public class LoginSuccessEntity {
	
	@Id
	
	@GeneratedValue(generator="dataid",strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String uname;
	@Temporal(TemporalType.DATE)
	private Calendar dateOfData;
	private Integer wifi;
	private Integer mobile;
	private Integer book;
	private Integer bus;
	private Integer home;
	private Integer shopping;
	private Integer food;
	private Integer party;
	private Integer other;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	public Integer getWifi() {
		return wifi;
	}
	public void setWifi(Integer wifi) {
		this.wifi = wifi;
	}
	public Integer getBook() {
		return book;
	}
	public void setBook(Integer book) {
		this.book = book;
	}
	public Integer getBus() {
		return bus;
	}
	public void setBus(Integer bus) {
		this.bus = bus;
	}
	public Integer getHome() {
		return home;
	}
	public void setHome(Integer home) {
		this.home = home;
	}
	public Integer getShopping() {
		return shopping;
	}
	public void setShopping(Integer shopping) {
		this.shopping = shopping;
	}
	public Integer getFood() {
		return food;
	}
	public void setFood(Integer food) {
		this.food = food;
	}
	public Integer getParty() {
		return party;
	}
	public void setParty(Integer party) {
		this.party = party;
	}
	public Integer getOther() {
		return other;
	}
	public void setOther(Integer other) {
		this.other = other;
	}
	public Calendar getDateOfData() {
		return dateOfData;
	}
	public void setDateOfData(Calendar dateOfData) {
		this.dateOfData = dateOfData;
	}
	
	
	

}
