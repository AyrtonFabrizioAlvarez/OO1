package ar.edu.unlp.info.oo1.ejercicio4_figurasYcuerpos;

public class Circulo implements Figura{
	private double radio;
	
	public double getDiametro() {
		return this.radio * 2;
	}
	
	public void setDiametro(double diametro) {
		this.radio = diametro / 2;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getPerimetro() {
		return Math.PI * this.getDiametro();
	}
	
	public double getArea() {
		return Math.PI * (radio * radio);
	}
}
