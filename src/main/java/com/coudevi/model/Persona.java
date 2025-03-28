package com.coudevi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// clase inversa
@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// debe de tener eun nombre con valor no permite nombres vacios
	@Column(nullable = false, length = 100)
	private String nombre;
	
	// Relacion de uno a uno
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private Documento documento;
	
	// Le sirve a la API de JPA
	public Persona() {
		
	}

	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	// metodo para trabajar con Documento
	public void asignarDocumento(Documento documento) {
		this.documento = documento;
		documento.setPersona(this);
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	
	
}
