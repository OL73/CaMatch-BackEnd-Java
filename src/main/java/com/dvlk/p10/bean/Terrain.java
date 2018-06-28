package com.dvlk.p10.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "terrain", catalog = "projet10")
public class Terrain implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Lieu lieu;
	private int joueurMax;
	private String libelle;
	private Integer prix;
	private Set<Salon> salons = new HashSet<Salon>(0);

	public Terrain() {
	}

	public Terrain(Lieu lieu, int joueurMax) {
		this.lieu = lieu;
		this.joueurMax = joueurMax;
	}

	public Terrain(Lieu lieu, int joueurMax, String libelle, Integer prix, Set<Salon> salons) {
		this.lieu = lieu;
		this.joueurMax = joueurMax;
		this.libelle = libelle;
		this.prix = prix;
		this.salons = salons;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	@Column(name = "joueurMax", nullable = false)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "terrain")
	public Set<Salon> getSalons() {
		return this.salons;
	}

	public void setSalons(Set<Salon> salons) {
		this.salons = salons;
	}

}
