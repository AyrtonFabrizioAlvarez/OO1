package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OOBnbTest {
	OOBnb sistema;
	Usuario usuario;
	Propiedad propiedad1;
	Propiedad propiedad2;
	DateLapse periodo;
	DateLapse periodoBuscado;
	
	@BeforeEach
	void setUp() {
		sistema = new OOBnb();
		
		usuario = sistema.registrarUsuario("nombreUsuario1", 123456, "direccionUsuario1");
		propiedad1 = sistema.registrarPropiedad("nombrePropiedad1", "descripcionPropiedad1", 1000, "direccionPropiedad1", usuario);
		propiedad2 = sistema.registrarPropiedad("nombrePropiedad2", "descripcionPropiedad2", 1000, "direccionPropiedad2", usuario);
		
		periodo = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		
	}

	@Test
	void testPropiedadesDisponiblesExisten() {
		sistema.hacerReserva(propiedad1, periodo, usuario);
		sistema.hacerReserva(propiedad2, periodo, usuario);
		periodoBuscado = new DateLapse(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 13));
		assertFalse(sistema.propiedadesDisponibles(periodoBuscado).isEmpty());
	}
	
	@Test
	void testPropiedadesDisponiblesNoExisten() {
		sistema.hacerReserva(propiedad1, periodo, usuario);
		sistema.hacerReserva(propiedad2, periodo, usuario);
		periodoBuscado = new DateLapse(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 12));
		assertTrue(sistema.propiedadesDisponibles(periodoBuscado).isEmpty());
	}

	@Test
	void testHacerReservaExitosa() {
		assertNotNull(sistema.hacerReserva(propiedad1, periodo, usuario));
	}
	
	@Test
	void testHacerReservaNoExitosa() {
		sistema.hacerReserva(propiedad1, periodo, usuario);
		assertNull(sistema.hacerReserva(propiedad1, periodo, usuario));
	}

	@Test
	void testIngresosPropietario() {
		sistema.hacerReserva(propiedad1, periodo, usuario);
		sistema.hacerReserva(propiedad2, periodo, usuario);
		LocalDate desde = LocalDate.of(2023, 10, 9);
		LocalDate hasta = LocalDate.of(2023, 10, 10);
		assertEquals(2000, sistema.ingresosPropietario(usuario, desde, hasta));
	}

}
