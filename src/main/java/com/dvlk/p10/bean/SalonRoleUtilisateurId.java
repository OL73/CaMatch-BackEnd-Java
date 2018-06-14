package com.dvlk.p10.bean;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SalonRoleUtilisateurId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int salonId;
	private int utilisateurId;

	public SalonRoleUtilisateurId() {
	}

	public SalonRoleUtilisateurId(int salonId, int utilisateurId) {
		this.salonId = salonId;
		this.utilisateurId = utilisateurId;
	}

	@Column(name = "salon_id", nullable = false)
	public int getSalonId() {
		return this.salonId;
	}

	public void setSalonId(int salonId) {
		this.salonId = salonId;
	}

	@Column(name = "utilisateur_id", nullable = false)
	public int getUtilisateurId() {
		return this.utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SalonRoleUtilisateurId))
			return false;
		SalonRoleUtilisateurId castOther = (SalonRoleUtilisateurId) other;

		return (this.getSalonId() == castOther.getSalonId())
				&& (this.getUtilisateurId() == castOther.getUtilisateurId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSalonId();
		result = 37 * result + this.getUtilisateurId();
		return result;
	}

}
