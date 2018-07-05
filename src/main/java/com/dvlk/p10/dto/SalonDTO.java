package com.dvlk.p10.dto;

import java.util.Date;

import com.dvlk.p10.bean.Sport;

public class SalonDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer idLieu;
	private String libelleLieu;
	private String libelleTerrain;
	private Sport sport;
	private String description;
	private String adresse;
	private Date date;
	private int joueurMax;
	private Integer nbJoueurs;
	private Integer idAdminSalon;
	private String fullNameAdminSalon;
	private Integer prix;

	public SalonDTO() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdLieu() {
		return this.idLieu;
	}

	public void setIdLieu(Integer idLieu) {
		this.idLieu = idLieu;
	}

	public String getLibelleLieu() {
		return this.libelleLieu;
	}

	public void setLibelleLieu(String libelleLieu) {
		this.libelleLieu = libelleLieu;
	}

	public String getLibelleTerrain() {
		return this.libelleTerrain;
	}

	public void setLibelleTerrain(String libelleTerrain) {
		this.libelleTerrain = libelleTerrain;
	}

	public Integer getPrix() {
		return this.prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return this.date;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getJoueurMax() {
		return this.joueurMax;
	}

	public void setJoueurMax(int joueurMax) {
		this.joueurMax = joueurMax;
	}

	public Integer getNbJoueurs() {
		return this.nbJoueurs;
	}

	public void setNbJoueurs(Integer nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public Integer getIdAdminSalon() {
		return this.idAdminSalon;
	}

	public void setIdAdminSalon(Integer idAdminSalon) {
		this.idAdminSalon = idAdminSalon;
	}

	public String getFullNameAdminSalon() {
		return this.fullNameAdminSalon;
	}

	public void setFullNameAdminSalon(String fullNameAdminSalon) {
		this.fullNameAdminSalon = fullNameAdminSalon;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
