package com.dvlk.p10.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "utilisateur", catalog = "projet10")
public class Utilisateur implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String pseudo;
	private String adresse;
	@Column(name = "codePostal")
	private String codePostal;
	private String telephone;
	private String email;
	private Float note;
	private Float penalite;
	private Integer niveau;
	private String description;
	private String password;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Lieu> lieus = new HashSet<Lieu>(0);
	private Set<SalonRoleUtilisateur> salonRoleUtilisateurs = new HashSet<SalonRoleUtilisateur>(0);
	private Set<Paiement> paiements = new HashSet<Paiement>(0);

	public Utilisateur() {
	}

	public Utilisateur(Date dateNaissance, String email) {
		this.dateNaissance = dateNaissance;
		this.email = email;
	}

	public Utilisateur(String nom, String prenom, Date dateNaissance, String adresse, String codePostal,
			String telephone, String email, Float note, Float penalite, Integer niveau, String description,
			String password, Set<Role> roles, Set<Lieu> lieus, Set<SalonRoleUtilisateur> salonRoleUtilisateurs,
			Set<Paiement> paiements) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.email = email;
		this.note = note;
		this.penalite = penalite;
		this.niveau = niveau;
		this.description = description;
		this.password = password;
		this.roles = roles;
		this.lieus = lieus;
		this.salonRoleUtilisateurs = salonRoleUtilisateurs;
		this.paiements = paiements;
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

	@Column(name = "nom", length = 150)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", length = 150)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateNaissance", nullable = false, length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "adresse", length = 150)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "codePostal", length = 150)
	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Column(name = "telephone", length = 150)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "email", nullable = false, length = 320)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "note", precision = 12, scale = 0)
	public Float getNote() {
		return this.note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	@Column(name = "penalite", precision = 12, scale = 0)
	public Float getPenalite() {
		return this.penalite;
	}

	public void setPenalite(Float penalite) {
		this.penalite = penalite;
	}

	@Column(name = "niveau")
	public Integer getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "utilisateur_role", catalog = "projet10", joinColumns = {
			@JoinColumn(name = "utilisateur_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Set<Lieu> getLieus() {
		return this.lieus;
	}

	public void setLieus(Set<Lieu> lieus) {
		this.lieus = lieus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Set<SalonRoleUtilisateur> getSalonRoleUtilisateurs() {
		return this.salonRoleUtilisateurs;
	}

	public void setSalonRoleUtilisateurs(Set<SalonRoleUtilisateur> salonRoleUtilisateurs) {
		this.salonRoleUtilisateurs = salonRoleUtilisateurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Set<Paiement> getPaiements() {
		return this.paiements;
	}

	public void setPaiements(Set<Paiement> paiements) {
		this.paiements = paiements;
	}

	@Column(name = "pseudo", length = 150, unique = true, nullable = true)
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [id=");
		builder.append(this.id);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append(", prenom=");
		builder.append(this.prenom);
		builder.append(", dateNaissance=");
		builder.append(this.dateNaissance);
		builder.append(", adresse=");
		builder.append(this.adresse);
		builder.append(", codePostal=");
		builder.append(this.codePostal);
		builder.append(", telephone=");
		builder.append(this.telephone);
		builder.append(", email=");
		builder.append(this.email);
		builder.append(", note=");
		builder.append(this.note);
		builder.append(", penalite=");
		builder.append(this.penalite);
		builder.append(", niveau=");
		builder.append(this.niveau);
		builder.append(", description=");
		builder.append(this.description);
		builder.append(", password=");
		builder.append(this.password);
		builder.append(", roles=");
		builder.append(this.roles);
		builder.append(", lieus=");
		builder.append(this.lieus);
		builder.append("]");
		return builder.toString();
	}

}
