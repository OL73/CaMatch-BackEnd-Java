
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
@Table(name = "paiement", catalog = "projet10")
public class Paiement implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private PaiementId id;
	private Salon salon;
	private Utilisateur utilisateur;
	private double prix;

	public Paiement() {
	}

	public Paiement(PaiementId id, Salon salon, Utilisateur utilisateur, double prix) {
		this.id = id;
		this.salon = salon;
		this.utilisateur = utilisateur;
		this.prix = prix;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "salonId", column = @Column(name = "salon_id", nullable = false)),
			@AttributeOverride(name = "utilisateurId", column = @Column(name = "utilisateur_id", nullable = false)) })
	public PaiementId getId() {
		return this.id;
	}

	public void setId(PaiementId id) {
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

	@Column(name = "prix", nullable = false, precision = 22, scale = 0)
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
