package ar.edu.unlp.info.oo1.ejercicio14_intervaloDeTiempo;

import java.time.LocalDate;
import java.time.Period;

public class DateLapse implements Lapse{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse() {
		
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	
	public void setTo(LocalDate to) {
		this.to = to;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public int sizeInDays() {
		return this.from.until(this.to).getDays();
	}
	
	public boolean includesDate(LocalDate other) {
		boolean enRango = false;
		if ( (other.isAfter(this.from)) && (other.isBefore(this.to)) ){
			enRango = true;
		}
		return enRango;
	}
}
