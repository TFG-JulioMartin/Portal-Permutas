package domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "propuesta")
public class Propuesta {

	// Constructors -----------------------------------------------------------

	public Propuesta() {
		super();
	}

	// Attributes -------------------------------------------------------------

	@Id
	private String id;
	private String titulo;
	private String texto;
	private boolean aceptada;
	private boolean pendiente;
	private String plazaId;
	private String remitenteId;
	private String destinatarioId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public boolean getPendiente() {
		return pendiente;
	}

	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}

	public String getPlazaId() {
		return plazaId;
	}

	public void setPlazaId(String plazaId) {
		this.plazaId = plazaId;
	}

	public String getRemitenteId() {
		return remitenteId;
	}

	public void setRemitenteId(String remitenteId) {
		this.remitenteId = remitenteId;
	}

	public String getDestinatarioId() {
		return destinatarioId;
	}

	public void setDestinatarioId(String destinatarioId) {
		this.destinatarioId = destinatarioId;
	}
}