package com.dvlk.p10.bean;

import java.util.Date;

public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private String email;
	private float note;
	private float penalite;
	private int niveau;
	private String description;
	private String motDePasse;
	
	public Utilisateur() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public float getPenalite() {
		return penalite;
	}

	public void setPenalite(float penalite) {
		this.penalite = penalite;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", note=");
		builder.append(note);
		builder.append(", penalite=");
		builder.append(penalite);
		builder.append(", niveau=");
		builder.append(niveau);
		builder.append(", description=");
		builder.append(description);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append("]");
		return builder.toString();
	}

	
}
