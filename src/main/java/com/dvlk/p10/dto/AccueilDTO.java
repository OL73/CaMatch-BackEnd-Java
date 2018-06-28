package com.dvlk.p10.dto;

import java.util.List;

public class AccueilDTO {

	private List<SalonDTO> salons;

	public AccueilDTO() {

	}

	public List<SalonDTO> getSalons() {
		return this.salons;
	}

	public void setSalons(List<SalonDTO> salons) {
		this.salons = salons;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getName());
		builder.append(" [salons=");
		builder.append(this.salons);
		builder.append("]");
		return builder.toString();
	}



}
