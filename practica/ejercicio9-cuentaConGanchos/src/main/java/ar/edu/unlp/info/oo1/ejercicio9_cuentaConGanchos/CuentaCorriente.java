package ar.edu.unlp.info.oo1.ejercicio9_cuentaConGanchos;

public class CuentaCorriente extends Cuenta {

	private double descubierto;
	
	public CuentaCorriente() {
		super();
		this.descubierto = 0;
	}
	
	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}
	
	
	public boolean puedeExtraer(double monto) {
		return ( (this.getSaldo() + this.descubierto) - monto >= 0 );
	}
}
