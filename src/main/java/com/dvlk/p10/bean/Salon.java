package com.dvlk.p10.bean;

import java.util.Date;

public class Salon {
	private int id;
	private Date date;
	private int joueursMax;
	public Salon() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getJoueursMax() {
		return joueursMax;
	}
	public void setJoueursMax(int joueursMax) {
		this.joueursMax = joueursMax;
	}
	
	

}
