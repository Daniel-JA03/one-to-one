package com.coudevi.model;
// clase propetario

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "documento")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipo;
	
	@Temporal(TemporalType.DATE)
	private Date fechaEcpedicion;
	
	@OneToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	public Documento() {
		// TODO Auto-generated constructor stub
	}

	public Documento(TipoDocumento tipo, Date fechaEcpedicion) {
		this.tipo = tipo;
		this.fechaEcpedicion = fechaEcpedicion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}

	public Date getFechaEcpedicion() {
		return fechaEcpedicion;
	}

	public void setFechaEcpedicion(Date fechaEcpedicion) {
		this.fechaEcpedicion = fechaEcpedicion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
