package com.dvlk.p10.bean;

public class Lieu {
	private int id;
	private String adresse;
	private String nom;
	private String codePostal;
	private String telephone;
	private String description;
	private boolean typePublic = false;
	
	public Lieu() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTypePublic() {
		return typePublic;
	}

	public void setTypePublic(boolean typePublic) {
		this.typePublic = typePublic;
	}

}
