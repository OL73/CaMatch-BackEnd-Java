package com.dvlk.p10.dto;

import java.util.HashSet;
import java.util.Set;

import com.dvlk.p10.bean.SalonRoleUtilisateur;
import com.dvlk.p10.bean.Utilisateur;

public class UtilisateurDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private Float note;
	private Float penalite;
	private Integer niveau;
	private String password;
	private Set<SalonRoleUtilisateur> salonRoleUtilisateurs = new HashSet<SalonRoleUtilisateur>(0);

	public UtilisateurDTO() {
		super();
	}

	public UtilisateurDTO(Utilisateur utilisateur) {
		this.setId(utilisateur.getId());
		this.setNiveau(utilisateur.getNiveau());
		this.setNom(utilisateur.getNom());
		this.setNote(utilisateur.getNote());
		this.setPenalite(utilisateur.getPenalite());
		this.setPrenom(utilisateur.getPrenom());
		this.setPseudo(utilisateur.getPseudo());
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Float getNote() {
		return this.note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public Float getPenalite() {
		return this.penalite;
	}

	public void setPenalite(Float penalite) {
		this.penalite = penalite;
	}

	public Integer getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public Set<SalonRoleUtilisateur> getSalonRoleUtilisateurs() {
		return this.salonRoleUtilisateurs;
	}

	public void setSalonRoleUtilisateurs(Set<SalonRoleUtilisateur> salonRoleUtilisateurs) {
		this.salonRoleUtilisateurs = salonRoleUtilisateurs;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UtilisateurDTO [id=");
		builder.append(this.id);
		builder.append(", pseudo=");
		builder.append(this.pseudo);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append(", prenom=");
		builder.append(this.prenom);
		builder.append(", note=");
		builder.append(this.note);
		builder.append(", penalite=");
		builder.append(this.penalite);
		builder.append(", niveau=");
		builder.append(this.niveau);
		builder.append("]");
		return builder.toString();
	}

}
