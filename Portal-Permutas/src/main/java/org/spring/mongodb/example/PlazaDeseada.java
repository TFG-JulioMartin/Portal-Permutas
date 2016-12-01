package org.spring.mongodb.example;

public class PlazaDeseada {

	private String id;
	private String titulo;
	private String centro;
	private String direccion;

	public PlazaDeseada(String titulo, String centro, String direccion) {
		super();
		this.titulo = titulo;
		this.centro = centro;
		this.direccion = direccion;
	}

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
		return "PlazaDeseada [id=" + id + ", titulo=" + titulo + ", centro=" + centro + ", direccion=" + direccion
				+ "]";
	}
}