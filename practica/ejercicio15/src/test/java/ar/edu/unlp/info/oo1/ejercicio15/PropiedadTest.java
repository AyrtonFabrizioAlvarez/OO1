package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	Propiedad propiedad;
	Usuario usuario;
	Reserva reserva1;
	DateLapse periodo1;
	Reserva reserva2;
	DateLapse periodo2;
	
	@BeforeEach
	void setUp() {
		usuario = new Usuario("nombreUsuario1", 123456, "direccionUsuario1");
		propiedad = new Propiedad("nombrePropiedad1", "descripcionPropiedad1", 1000, "direccionPropiedad1");
	}

	@Test
	void testIsLibre() {
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(20230, 10, 11));
		reserva1 = new Reserva(propiedad, periodo1, usuario);
		propiedad.añadirReserva(reserva1);
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 13));
		reserva2 = new Reserva(propiedad, periodo2, usuario);
		assertTrue(propiedad.isLibre(periodo2));
	}
	
	@Test
	void testIsNotLibre() {
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		reserva1 = new Reserva(propiedad, periodo1, usuario);
		propiedad.añadirReserva(reserva1);
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 12));
		reserva2 = new Reserva(propiedad, periodo2, usuario);
		assertFalse(propiedad.isLibre(periodo2));
	}

	@Test
	void testEliminarReservaSiendoFutura() {
		periodo1 = new DateLapse(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 2));
		reserva1 = new Reserva(propiedad, periodo1, usuario);
		propiedad.añadirReserva(reserva1);
		propiedad.eliminarReserva(reserva1);
		assertTrue(propiedad.getReservas().isEmpty());
	}
	
	@Test
	void testEliminarReservaSinSerFutura() {
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 13), LocalDate.of(2023, 10, 14));
		reserva1 = new Reserva(propiedad, periodo1, usuario);
		propiedad.añadirReserva(reserva1);
		propiedad.eliminarReserva(reserva1);
		assertFalse(propiedad.getReservas().isEmpty());
	}

	@Test
	void testMontoAlquilerEntreFechasConReservas() {
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		reserva1 = new Reserva(propiedad, periodo1, usuario);
		propiedad.añadirReserva(reserva1);
		assertFalse(propiedad.getReservas().isEmpty());
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 13));
		reserva2 = new Reserva(propiedad, periodo2, usuario);
		propiedad.añadirReserva(reserva2);
		LocalDate desde = LocalDate.of(2023, 10, 9);
		LocalDate hasta = LocalDate.of(2023, 10, 12);
		assertEquals(2000, propiedad.montoAlquilerEntreFechas(desde, hasta));
	}
	
	@Test
	void testMontoAlquilerEntreFechasSinReservas() {
		LocalDate desde = LocalDate.of(2023, 10, 9);
		LocalDate hasta = LocalDate.of(2023, 10, 12);
		assertEquals(0, propiedad.montoAlquilerEntreFechas(desde, hasta));
	}

}
