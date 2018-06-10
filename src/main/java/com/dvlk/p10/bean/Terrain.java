package com.dvlk.p10.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "terrain", catalog = "projet10")
public class Terrain implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Lieu lieu;
	private int joueurMax;
	private String libelle;
	private Integer prix;

	public Terrain() {
	}

	public Terrain(int id, Lieu lieu, int joueurMax) {
		this.id = id;
		this.lieu = lieu;
		this.joueurMax = joueurMax;
	}

	public Terrain(int id, Lieu lieu, int joueurMax, String libelle, Integer prix) {
		this.id = id;
		this.lieu = lieu;
		this.joueurMax = joueurMax;
		this.libelle = libelle;
		this.prix = prix;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lieu_id", nullable = false)
	public Lieu getLieu() {
		return this.lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	@Column(name = "joueur_max", nullable = false)
	public int getJoueurMax() {
		return this.joueurMax;
	}

	public void setJoueurMax(int joueurMax) {
		this.joueurMax = joueurMax;
	}

	@Column(name = "libelle", length = 150)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Column(name = "prix")
	public Integer getPrix() {
		return this.prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

}
