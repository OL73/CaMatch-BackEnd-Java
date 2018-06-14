
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", catalog = "projet10")
public class Role implements java.io.Serializable {

	private Integer id;
	private String libelle;
	private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>(0);

	public Role() {
	}

	public Role(String libelle) {
		this.libelle = libelle;
	}

	public Role(String libelle, Set<Utilisateur> utilisateurs) {
		this.libelle = libelle;
		this.utilisateurs = utilisateurs;
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

	@Column(name = "libelle", nullable = false, length = 150)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "utilisateur_role", catalog = "projet10", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "utilisateur_id", nullable = false, updatable = false) })
	public Set<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}
