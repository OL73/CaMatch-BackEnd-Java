
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

@Entity
@Table(name = "lieu", catalog = "projet10")
public class Lieu implements java.io.Serializable {

	private Integer id;
	private Utilisateur utilisateur;
	private String adresse;
	private String nom;
	private String codePostal;
	private String telephone;
	private String description;
	private boolean gratuit;
	private Set<Salon> salons = new HashSet<Salon>(0);
	private Set<Terrain> terrains = new HashSet<Terrain>(0);

	public Lieu() {
	}

	public Lieu(Utilisateur utilisateur, String adresse, boolean gratuit) {
		this.utilisateur = utilisateur;
		this.adresse = adresse;
		this.gratuit = gratuit;
	}

	public Lieu(Utilisateur utilisateur, String adresse, String nom, String codePostal, String telephone,
			String description, boolean gratuit, Set<Salon> salons, Set<Terrain> terrains) {
		this.utilisateur = utilisateur;
		this.adresse = adresse;
		this.nom = nom;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.description = description;
		this.gratuit = gratuit;
		this.salons = salons;
		this.terrains = terrains;
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
	@JoinColumn(name = "utilisateur_id", nullable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Column(name = "adresse", nullable = false, length = 150)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "nom", length = 150)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "gratuit", nullable = false)
	public boolean isGratuit() {
		return this.gratuit;
	}

	public void setGratuit(boolean gratuit) {
		this.gratuit = gratuit;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lieu")
	public Set<Salon> getSalons() {
		return this.salons;
	}

	public void setSalons(Set<Salon> salons) {
		this.salons = salons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lieu")
	public Set<Terrain> getTerrains() {
		return this.terrains;
	}

	public void setTerrains(Set<Terrain> terrains) {
		this.terrains = terrains;
	}

}
