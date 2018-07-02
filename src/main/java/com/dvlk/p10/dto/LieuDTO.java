package com.dvlk.p10.dto;

public class LieuDTO {

	private String nom;
	private String adresse;
	private String codePostal;
	private String telephone;
	private String description;
	private Boolean publique;

	public LieuDTO() {
		super();
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPublique() {
		return this.publique;
	}

	public void setPublique(Boolean publique) {
		this.publique = publique;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LieuDTO [nom=");
		builder.append(this.nom);
		builder.append(", adresse=");
		builder.append(this.adresse);
		builder.append(", codePostal=");
		builder.append(this.codePostal);
		builder.append(", telephone=");
		builder.append(this.telephone);
		builder.append(", description=");
		builder.append(this.description);
		builder.append(", publique=");
		builder.append(this.publique);
		builder.append("]");
		return builder.toString();
	}
}
