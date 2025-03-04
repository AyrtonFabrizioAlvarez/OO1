package ar.edu.unlp.info.oo1.ejercicio9_cuentaConGanchos;

public class CajaDeAhorro extends Cuenta {


	public boolean extraer(double monto) {
		return super.extraer(monto*1.02);
	}
	
	public boolean puedeExtraer(double monto) {
		return this.getSaldo() >= monto*1.02;
	}
	
}
