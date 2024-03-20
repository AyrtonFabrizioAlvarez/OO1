package ar.edu.unlp.info.oo1.ejercicio14_intervaloDeTiempo;

import java.time.LocalDate;

public interface Lapse {
	public LocalDate getFrom();
	public LocalDate getTo();
	public int sizeInDays();
	public void setFrom(LocalDate from);
	public boolean includesDate(LocalDate other);
}
