package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	Carpeta carpeta;
	Email email;
	
	@BeforeEach
	void setUp() {
		carpeta = new Carpeta("carpetaa");
		email = new Email("titulo1", "cuerpo1");
	}
	@Test
	void testAgregarEmail() {
		carpeta.agregarEmail(email);
		assertEquals(1, carpeta.getCantEmails());
	}

	@Test
	void testBorrarEmail() {
		carpeta.agregarEmail(email);
		carpeta.borrarEmail(email);
		assertEquals(0, carpeta.getCantEmails());
	}

	@Test
	void testBorrarEmail2() {
		carpeta.borrarEmail(email);
		assertEquals(0, carpeta.getCantEmails());
	}
	
	@Test
	void testBuscar() {
		carpeta.agregarEmail(email);
		assertEquals(email, carpeta.buscar("titulo1"));
		assertNull(carpeta.buscar("titulo"));
	}

	@Test
	void testGetTamanio() {
		carpeta.agregarEmail(email);
		assertEquals(14, carpeta.getTamanio());
	}

}
