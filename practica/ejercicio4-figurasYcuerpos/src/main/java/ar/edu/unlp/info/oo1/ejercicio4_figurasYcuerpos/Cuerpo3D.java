package ar.edu.unlp.info.oo1.ejercicio4_figurasYcuerpos;

public class Cuerpo3D {
	private Figura caraBasal;
	private double altura;
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal(Figura cara) {
		this.caraBasal = cara;
	}
	
	public double getVolumen() {
		return this.caraBasal.getArea() * this.altura;
	}
	
	public double getSuperficieExterior() {
		return (2 * this.caraBasal.getArea()) + (this.caraBasal.getPerimetro() * this.altura);
	}
}
