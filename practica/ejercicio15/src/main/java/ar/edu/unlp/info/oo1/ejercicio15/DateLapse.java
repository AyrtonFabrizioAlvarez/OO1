package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
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
		if ( ( (other.isAfter(this.from)) || (other.isEqual(this.from)) ) && ( (other.isBefore(this.to)) || (other.isEqual(this.to)) ) ){
			enRango = true;
		}
		return enRango;
	}
	
	public boolean overlapse(DateLapse other) {
		boolean seSolapan = false;
		if ( (other.includesDate(this.from)) || (other.includesDate(this.to)) ) {
			seSolapan = true;
		}
		return seSolapan;
	}
}
