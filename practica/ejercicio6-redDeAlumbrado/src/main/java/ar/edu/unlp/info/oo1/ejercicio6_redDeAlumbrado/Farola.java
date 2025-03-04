package ar.edu.unlp.info.oo1.ejercicio6_redDeAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private boolean estado;
	private List<Farola> vecinos;
	
	public Farola () {
		this.estado = false;
		this.vecinos = new ArrayList<>();
	}
	
	public void pairWithNeighbor( Farola otraFarola ) {
		this.addNeighbor(otraFarola);
		otraFarola.addNeighbor(this);
	}
	
	public void addNeighbor(Farola otraFarola) {
		this.vecinos.add(otraFarola);
	}
	
	public List<Farola> getNeighbors(){
		return this.vecinos;
	}
	
	public void turnOn() {
		if (!this.isOn()) {
			this.estado = true;
			this.vecinos.stream().forEach(farola -> farola.turnOn());		
		}
	}
	
	public void turnOff() {
		if (this.isOn()) {
			this.estado = false;
			this.vecinos.stream().forEach(farola -> farola.turnOff());
		}
	}
	
	public boolean isOn() {
		return this.estado;
	}
}
