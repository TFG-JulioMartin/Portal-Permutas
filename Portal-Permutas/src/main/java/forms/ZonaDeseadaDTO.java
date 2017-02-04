package forms;

import org.springframework.data.annotation.Id;

public class ZonaDeseadaDTO {

	// Constructors -----------------------------------------------------------

	public ZonaDeseadaDTO() {
		super();
	}

	// Attributes -------------------------------------------------------------

	@Id
	private String id;
	private Double slat;
	private Double slng;
	private Double elat;
	private Double elng;
	private String usuarioId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getSlat() {
		return slat;
	}

	public void setSlat(Double slat) {
		this.slat = slat;
	}

	public Double getSlng() {
		return slng;
	}

	public void setSlng(Double slng) {
		this.slng = slng;
	}

	public Double getElat() {
		return elat;
	}

	public void setElat(Double elat) {
		this.elat = elat;
	}

	public Double getElng() {
		return elng;
	}

	public void setElng(Double elng) {
		this.elng = elng;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

}