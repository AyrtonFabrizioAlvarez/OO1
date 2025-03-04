package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	Email emailConAdjuntos;
	Email emailSinAdjuntos;
	Archivo archivo;
	
	@BeforeEach
	void setUp() {
		emailConAdjuntos = new Email("titulo", "cuerpo");
		archivo = new Archivo("archivo");
		emailConAdjuntos.agregarAdjunto(archivo);
		
		emailSinAdjuntos = new Email("titulo2", "cuerpo2");
	}
	
	@Test
	void testCoincideCon() {
		assertTrue(emailConAdjuntos.coincideCon("titulo"));
	}
	
	@Test
	void testNoCoincideCon() {
		assertFalse(emailConAdjuntos.coincideCon("titul"));
	}

	@Test
	void testGetTamanioSinAdjuntos() {
		assertEquals(14, emailSinAdjuntos.getTamanio());
	}
	
	@Test
	void testGetTamanioConAdjuntos() {
		assertEquals(19, emailConAdjuntos.getTamanio());
	}

}
