package com.dvlk.p10.bean;

public class Terrain {
	private int id;
	private int joueursMax;
	private String libelle;
	private double prix;
	
	public Terrain() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJoueursMax() {
		return joueursMax;
	}

	public void setJoueursMax(int joueursMax) {
		this.joueursMax = joueursMax;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	

}
