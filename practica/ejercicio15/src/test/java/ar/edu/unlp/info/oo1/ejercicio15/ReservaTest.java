package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	Reserva reserva;
	Usuario usuario;
	DateLapse periodo;
	DateLapse periodo2;
	Propiedad propiedad;
	
	
	@BeforeEach
	void setUp() {
		usuario = new Usuario("nombreUsuario1", 123456, "direccionUsuario1");
		propiedad = new Propiedad("nombrePropiedad1", "descripcionPropiedad1", 1000, "direccionPropiedad1");
		
	}
	@Test
	void testCalcularPrecioConDias() {
		periodo = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		reserva = new Reserva(propiedad, periodo, usuario);
		assertEquals(1000, reserva.calcularPrecio());
	}
	
	@Test
	void testCalcularPrecioSinDias() {
		periodo = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 10));
		reserva = new Reserva(propiedad, periodo, usuario);
		assertEquals(0, reserva.calcularPrecio());
	}

	@Test
	void testIsOverlapsed() {
		periodo = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 12));
		reserva = new Reserva(propiedad, periodo, usuario);
		assertTrue(reserva.isOverlapsed(periodo2));
	}
	
	@Test
	void testNotOverlapsed() {
		periodo = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 23));
		reserva = new Reserva(propiedad, periodo, usuario);
		assertFalse(reserva.isOverlapsed(periodo2));
	}

	@Test
	void testIsFutura() {
		periodo = new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 2));
		LocalDate fechaActual = LocalDate.now();
		reserva = new Reserva(propiedad, periodo, usuario);
		assertTrue(reserva.isFutura(fechaActual));
	}
	
	@Test
	void testIsNotFutura() {
		periodo = new DateLapse(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 13));
		LocalDate fechaActual = LocalDate.now();
		reserva = new Reserva(propiedad, periodo, usuario);
		assertFalse(reserva.isFutura(fechaActual));
	}

}
