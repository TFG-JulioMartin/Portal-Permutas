package domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coincidencia")
public class Coincidencia {

	// Constructors -----------------------------------------------------------

	public Coincidencia() {
		super();
	}

	// Attributes -------------------------------------------------------------

	@Id
	private String id;
	private String plaza1Id;
	private String plaza2Id;
	private String titulo;
	private String texto;
	private boolean aceptada;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlaza1Id() {
		return plaza1Id;
	}

	public void setPlaza1Id(String plaza1Id) {
		this.plaza1Id = plaza1Id;
	}

	public String getPlaza2Id() {
		return plaza2Id;
	}

	public void setPlaza2Id(String plaza2Id) {
		this.plaza2Id = plaza2Id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean getAceptada() {
		return aceptada;
	}

	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

	@Override
	public String toString() {
		return "Coincidencia [id=" + id + ", plaza1Id=" + plaza1Id + ", plaza2Id=" + plaza2Id + "]";
	}
}