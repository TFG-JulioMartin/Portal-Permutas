package domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PlazaDeseada")
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

	@Override
	public String toString() {
		return "PlazaDeseada [cuidad=" + cuidad + ", zona=" + zona + "]";
	}
}