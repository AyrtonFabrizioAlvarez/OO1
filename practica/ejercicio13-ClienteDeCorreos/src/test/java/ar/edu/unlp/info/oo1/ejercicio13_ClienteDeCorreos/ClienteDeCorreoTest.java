package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteDeCorreoTest {
	ClienteDeCorreo cliente;
	Carpeta origen;
	Carpeta destino;
	Email email;
	
	@BeforeEach
	void setUp() {
		cliente = new ClienteDeCorreo();
		origen = new Carpeta("origen");
		destino = new Carpeta("destino");
		cliente.agregarCarpeta(origen);
		cliente.agregarCarpeta(destino);
		email = new Email("titulo", "cuerpo");
		origen.agregarEmail(email);
	}
	
	@Test
	void testMover() {
		assertEquals(1, origen.getCantEmails());
		cliente.mover(email, origen, destino);
		assertEquals(0, origen.getCantEmails());
		assertEquals(1, destino.getCantEmails());
	}

	@Test
	void testBuscarExistente() {
		assertEquals(email, cliente.buscar("titulo"));
	}
	
	@Test
	void testBuscarNoExistente() {
		assertNull(cliente.buscar("noExiste"));
	}

	@Test
	void testEspacioOcupado() {
		assertEquals(12, cliente.espacioOcupado());
	}

}
