package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest {
	private Archivo archivo;
	
	@BeforeEach
	void setUp() {
		archivo = new Archivo("holaArchivo");
	}
	@Test
	void testGetTamanio() {
		assertEquals(11, archivo.getTamanio());
	}

}
