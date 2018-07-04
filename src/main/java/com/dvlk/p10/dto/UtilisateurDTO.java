package com.dvlk.p10.dto;

import java.util.HashSet;
import java.util.Set;

import com.dvlk.p10.bean.Role;
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
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<SalonRoleUtilisateur> salonRoleUtilisateurs = new HashSet<SalonRoleUtilisateur>(0);

	public UtilisateurDTO() {
		super();
	}

	public UtilisateurDTO(Utilisateur utilisateur) {
		this.setId(utilisateur.getId());
		this.setNiveau(utilisateur.getNiveau());
		this.setNom(utilisateur.getNom());
		this.setPrenom(utilisateur.getPrenom());
		this.setNote(utilisateur.getNote());
		this.setPenalite(utilisateur.getPenalite());
		this.setPseudo(utilisateur.getPseudo());
		this.setEmail(utilisateur.getEmail());
		this.setRoles(utilisateur.getRoles());
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UtilisateurDTO [id=");
		builder.append(id);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", note=");
		builder.append(note);
		builder.append(", penalite=");
		builder.append(penalite);
		builder.append(", niveau=");
		builder.append(niveau);
		builder.append(", password=");
		builder.append(password);
		builder.append(", roles=");
		builder.append(roles);
		builder.append(", salonRoleUtilisateurs=");
		builder.append(salonRoleUtilisateurs);
		builder.append("]");
		return builder.toString();
	}

}
