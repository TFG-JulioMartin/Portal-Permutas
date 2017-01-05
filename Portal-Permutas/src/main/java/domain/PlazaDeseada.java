package domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plazaDeseada")
public class PlazaDeseada {

	// Constructors -----------------------------------------------------------

	public PlazaDeseada() {
		super();
	}

	// Attributes -------------------------------------------------------------

	@Id
	private String id;
	private String cuidad;
	private String zona;
	private String usuarioId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCuidad() {
		return cuidad;
	}

	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

}