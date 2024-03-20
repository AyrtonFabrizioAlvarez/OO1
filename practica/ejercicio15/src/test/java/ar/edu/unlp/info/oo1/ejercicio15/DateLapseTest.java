package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseTest {
	private DateLapse periodo;
	private LocalDate desde1;
	private LocalDate hasta1;
	
	private DateLapse periodoNoSolapadoFuturo;
	private LocalDate desde2;
	private LocalDate hasta2;
	
	private DateLapse periodoNoSolapadoPasado;
	private LocalDate desde3;
	private LocalDate hasta3;
	
	private DateLapse periodoSolapadoDesde;
	private LocalDate desde4;
	private LocalDate hasta4;
	
	private DateLapse periodoSolapadoHasta;
	private LocalDate desde5;
	private LocalDate hasta5;
	
	@BeforeEach
	void setUp() {
		desde1 = LocalDate.of(2023, 10, 10);
		hasta1 = LocalDate.of(2023, 10, 11);
		periodo = new DateLapse(desde1, hasta1);
		
		desde2 = LocalDate.of(2023, 10, 12);
		hasta2 = LocalDate.of(2023, 10, 13);
		periodoNoSolapadoFuturo = new DateLapse(desde2, hasta2);
		
		desde3 = LocalDate.of(2023, 10, 8);
		hasta3 = LocalDate.of(2023, 10, 9);
		periodoNoSolapadoPasado = new DateLapse(desde3, hasta3);
		
		desde4 = LocalDate.of(2023, 10, 9);
		hasta4 = LocalDate.of(2023, 10, 10);
		periodoSolapadoDesde = new DateLapse(desde4, hasta4);
		
		desde5 = LocalDate.of(2023, 10, 11);
		hasta5 = LocalDate.of(2023, 10, 12);
		periodoSolapadoHasta = new DateLapse(desde5, hasta5);
		
	}
	@Test
	void testOverlapse() {
		assertTrue(periodo.overlapse(periodoSolapadoDesde));
		assertTrue(periodo.overlapse(periodoSolapadoHasta));
		assertFalse(periodo.overlapse(periodoNoSolapadoFuturo));
		assertFalse(periodo.overlapse(periodoNoSolapadoPasado));
	}

}
