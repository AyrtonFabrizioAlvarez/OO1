package ar.edu.unlp.info.oo1.ejercicio14_intervaloDeTiempo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pruebaConInterfaz.DateLapse2;

class DateLapseTest {
	DateLapse intervalo;
	DateLapse2 intervalo2;
	LocalDate desde;
	LocalDate hasta;
	LocalDate enRango;
	LocalDate fueraDeRango;
	
	
	@BeforeEach
	void setUp() {
		desde = LocalDate.of(2023, 10, 1);
		hasta = LocalDate.of(2023, 10, 9);
		intervalo = new DateLapse();
		intervalo.setFrom(desde);
		intervalo.setTo(hasta);
		enRango = LocalDate.of(2023, 10, 5);
		fueraDeRango = LocalDate.of(2024, 1, 1);
		
		intervalo2 = new DateLapse2();
		intervalo2.setFrom(desde);
		intervalo2.setSizeInDays(8);
	}
	@Test
	void testSizeInDays() {
		assertEquals(8, intervalo.sizeInDays());
	}

	@Test
	void testIncludesDate() {
		assertTrue(intervalo.includesDate(enRango));
		assertTrue(intervalo2.includesDate(enRango));
	}
	
	@Test
	void testNotIncludesDate() {
		assertFalse(intervalo.includesDate(fueraDeRango));
		assertFalse(intervalo2.includesDate(fueraDeRango));
	}
	
	//@Test
	//void testGetTo() {
	//	assertEquals(hasta, intervalo2.getTo());
	//}

}
