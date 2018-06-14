package com.dvlk.p10.bean;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "salon", catalog = "projet10")
public class Salon implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Lieu lieu;
	private Sport sport;
	private Date date;
	private int joueurMax;
	private Set<SalonRoleUtilisateur> salonRoleUtilisateurs = new HashSet<SalonRoleUtilisateur>(0);
	private Set<Paiement> paiements = new HashSet<Paiement>(0);

	public Salon() {
	}

	public Salon(Lieu lieu, Sport sport, Date date, int joueurMax) {
		this.lieu = lieu;
		this.sport = sport;
		this.date = date;
		this.joueurMax = joueurMax;
	}

	public Salon(Lieu lieu, Sport sport, Date date, int joueurMax, Set<SalonRoleUtilisateur> salonRoleUtilisateurs,
			Set<Paiement> paiements) {
		this.lieu = lieu;
		this.sport = sport;
		this.date = date;
		this.joueurMax = joueurMax;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lieu_id", nullable = false)
	public Lieu getLieu() {
		return this.lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sport_id", nullable = false)
	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "joueur_max", nullable = false)
	public int getJoueurMax() {
		return this.joueurMax;
	}

	public void setJoueurMax(int joueurMax) {
		this.joueurMax = joueurMax;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "salon")
	public Set<SalonRoleUtilisateur> getSalonRoleUtilisateurs() {
		return this.salonRoleUtilisateurs;
	}

	public void setSalonRoleUtilisateurs(Set<SalonRoleUtilisateur> salonRoleUtilisateurs) {
		this.salonRoleUtilisateurs = salonRoleUtilisateurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "salon")
	public Set<Paiement> getPaiements() {
		return this.paiements;
	}

	public void setPaiements(Set<Paiement> paiements) {
		this.paiements = paiements;
	}

}
