
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "terrain", catalog = "projet10")
public class Terrain implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Lieu lieu;
	private int capaciteMax;
	private String libelle;
	private Integer prix;

	public Terrain() {
	}

	public Terrain(Lieu lieu, int capaciteMax) {
		this.lieu = lieu;
		this.capaciteMax = capaciteMax;
	}

	public Terrain(Lieu lieu, int capaciteMax, String libelle, Integer prix) {
		this.lieu = lieu;
		this.capaciteMax = capaciteMax;
		this.libelle = libelle;
		this.prix = prix;
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

	@Column(name = "capacite_max", nullable = false)
	public int getCapaciteMax() {
		return this.capaciteMax;
	}

	public void setCapaciteMax(int capaciteMax) {
		this.capaciteMax = capaciteMax;
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
