
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salon_role_utilisateur", catalog = "projet10")
public class SalonRoleUtilisateur implements java.io.Serializable {

	private SalonRoleUtilisateurId id;
	private Salon salon;
	private Utilisateur utilisateur;
	private String role;

	public SalonRoleUtilisateur() {
	}

	public SalonRoleUtilisateur(SalonRoleUtilisateurId id, Salon salon, Utilisateur utilisateur, String role) {
		this.id = id;
		this.salon = salon;
		this.utilisateur = utilisateur;
		this.role = role;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "salonId", column = @Column(name = "salon_id", nullable = false)),
			@AttributeOverride(name = "utilisateurId", column = @Column(name = "utilisateur_id", nullable = false)) })
	public SalonRoleUtilisateurId getId() {
		return this.id;
	}

	public void setId(SalonRoleUtilisateurId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salon_id", nullable = false, insertable = false, updatable = false)
	public Salon getSalon() {
		return this.salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utilisateur_id", nullable = false, insertable = false, updatable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
