package domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plazaPropia")
public class PlazaPropia {

	// Constructors -----------------------------------------------------------

	public PlazaPropia() {
		super();
	}

	// Attributes -------------------------------------------------------------

	@Id
	private String id;
	private String titulo;
	private String ciudad;
	private String centro;
	private String direccion;

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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "PlazaPropia [id=" + id + ", titulo=" + titulo + ", ciudad=" + ciudad + ", centro=" + centro
				+ ", direccion=" + direccion + "]";
	}

}