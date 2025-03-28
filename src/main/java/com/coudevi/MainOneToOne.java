package com.coudevi;

import java.util.Date;

import com.coudevi.model.Documento;
import com.coudevi.model.Persona;
import com.coudevi.model.TipoDocumento;
import com.coudevi.service.PersonaService;

public class MainOneToOne {

	public static void main(String[] args) {
		PersonaService service = new PersonaService();
		
		/*Crear*/
		/*Persona persona = new Persona("Aaron");
		
		Documento documento = new Documento(TipoDocumento.PASAPORTE, new Date());
		
		
		persona.asignarDocumento(documento);
		
		service.crearPersona(persona);*/
		
		service.obtenerPersonas().forEach(p -> {
			System.out.println("Persona : " + p.getNombre());
			if (p.getDocumento() != null) {
				System.out.println(" Documento Tipo " + p.getDocumento().getTipo());
				System.out.println(" Fecha Expedición " + p.getDocumento().getFechaEcpedicion());
			}
		});
		service.cerrar();
		
	}

}
