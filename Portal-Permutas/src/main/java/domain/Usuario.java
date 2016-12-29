package domain;

import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario extends Actor {

	// Constructors -----------------------------------------------------------

	public Usuario() {
		super();
	}

	// Attributes -------------------------------------------------------------

	private String plazaPropiaId;
	private Collection<String> plazasDeseadasId;

	public String getPlazaPropiaId() {
		return plazaPropiaId;
	}

	public void setPlazaPropiaId(String plazaPropiaId) {
		this.plazaPropiaId = plazaPropiaId;
	}

	public Collection<String> getPlazasDeseadasId() {
		return plazasDeseadasId;
	}

	public void setPlazasDeseadasId(Collection<String> plazasDeseadasId) {
		this.plazasDeseadasId = plazasDeseadasId;
	}

	@Override
	public String toString() {
		return "Usuario [plazaPropiaId=" + plazaPropiaId + ", plazasDeseadasId=" + plazasDeseadasId + ", getNombre()="
				+ getNombre() + ", getApellidos()=" + getApellidos() + ", getTelefono()=" + getTelefono()
				+ ", getEmail()=" + getEmail() + ", getUserAccountId()=" + getUserAccountId() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}