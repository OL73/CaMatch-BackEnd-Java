package com.dvlk.p10.dto;

import java.util.Date;


public class SalonDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer idLieu;
	private String libelleLieu;

	// private Sport sport;
	// TODO Format de la date a gerer
	private Date date;
	private int joueurMax;
	private Integer nbJoueurs;

	private Integer idAdminSalon;
	private String fullNameAdminSalon;

	// private Set<SalonRoleUtilisateur> salonRoleUtilisateurs = new
	// HashSet<SalonRoleUtilisateur>(0);
	// private Set<Paiement> paiements = new HashSet<Paiement>(0);

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

	public Date getDate() {
		return this.date;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getName());
		builder.append(" [id=");
		builder.append(this.id);
		builder.append(", idLieu=");
		builder.append(this.idLieu);
		builder.append(", libelleLieu=");
		builder.append(this.libelleLieu);
		builder.append(", date=");
		builder.append(this.date);
		builder.append(", joueurMax=");
		builder.append(this.joueurMax);
		builder.append(", nbJoueurs=");
		builder.append(this.nbJoueurs);
		builder.append(", idAdminSalon=");
		builder.append(this.idAdminSalon);
		builder.append(", fullNameAdminSalon=");
		builder.append(this.fullNameAdminSalon);
		builder.append("]");
		return builder.toString();
	}

}
