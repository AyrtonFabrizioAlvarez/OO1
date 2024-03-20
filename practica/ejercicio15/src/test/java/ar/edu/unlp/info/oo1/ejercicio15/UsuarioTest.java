package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	Usuario usuario;
	Propiedad propiedad;
	Reserva reserva1;
	DateLapse periodo1;
	DateLapse periodo2;
	Propiedad propiedad2;
	Reserva reserva2;
	
	@BeforeEach
	void setUp() {
		usuario = new Usuario("nombreUsuario1", 123456, "direccionUsuario1");
		propiedad = new Propiedad("nombrePropiedad1", "descripcionPropiedad1", 1000, "direccionPropiedad1");
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		reserva1 = new Reserva(propiedad, periodo1, usuario);
		usuario.añadirPropiedad(propiedad);
		usuario.añadirReserva(reserva1);
		propiedad.añadirReserva(reserva1);
	}

	@Test
	void testObtenerPropiedadesDisponiblesExisten() {
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 13));
		assertFalse(usuario.obtenerPropiedadesDisponibles(periodo2).isEmpty());
	}
	
	@Test
	void testObtenerPropiedadesDisponiblesNoExisten() {
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 13));
		assertTrue(usuario.obtenerPropiedadesDisponibles(periodo2).isEmpty());
	}

	@Test
	void testCalcularIngresos() {
		propiedad2 = new Propiedad("nombrePropiedad1", "descripcionPropiedad1", 1000, "direccionPropiedad1");
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		reserva2 = new Reserva(propiedad, periodo1, usuario);
		usuario.añadirPropiedad(propiedad2);
		usuario.añadirReserva(reserva2);
		propiedad.añadirReserva(reserva2);
		assertEquals(2000, usuario.calcularIngresos(LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10)));
	}

}
