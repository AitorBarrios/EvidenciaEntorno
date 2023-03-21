package Main;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
	private List<Double> saldo;
	private double credito;
	private double prestamo;
	private boolean tienePrestamo;

	public CuentaBancaria() {
		saldo = new ArrayList<Double>();
		credito = 0;
		prestamo = 0;
		tienePrestamo = false;
	}

	public void agregarSaldo(double cantidad) {
		if (prestamo > 0) {
			prestamo -= cantidad;
			if (prestamo < 0) {
				saldo.add(obtenerSaldo() + Math.abs(prestamo));
				prestamo = 0;
				tienePrestamo = false;
			}
		} else {
			saldo.add(obtenerSaldo() + cantidad);
		}
	}

	public void retirarSaldo(double cantidad) throws Exception {
		if (cantidad > obtenerSaldo() + credito) {
			throw new Exception("No hay suficiente saldo disponible");
		}
		saldo.add(obtenerSaldo() - cantidad);
	}
	/**
	 * La función retirar saldo nos sirve para restar saldo
	 *  a nuestras operaciones, este contiene un if que sirve
	 *   para que en caso de que el numero pedido sea mayor que
	 *    el saldo disponible no podamos retirar nada, y em caso
	 *    de poder retirarlo reste la cantidad retirada.
	 *    @param cantidad (numero a retirar)
	 *    @param obtenerSaldo() (saldo que se introduce)
	 *    @param credito (dinero disponible en la cuenta)
	 *    @author campusfp
	 *    @version 1.0.1
	 * **/

	public double obtenerSaldo() {
		return saldo.isEmpty() ? 0 : saldo.get(saldo.size() - 1);
	}

	public void modificarCredito(double cantidad) throws Exception {
		if (obtenerSaldo() + cantidad < 0) {
			throw new Exception("El nuevo credito no puede ser aplicado");
		}
		credito = cantidad;
	}

	public double obtenerPrestamo() {
		return prestamo;
	}

	public void solicitarPrestamo(double cantidad) throws Exception {
		if (tienePrestamo || obtenerSaldo()==0) {
			throw new Exception("No se le puede realizar un prestamo");
		}
		for (Double monto : saldo) {
			if (cantidad / 3 > monto) {
				cantidad = monto * 3;
			}
		}
		prestamo = cantidad;
		tienePrestamo = true;
		saldo.add(obtenerSaldo() + cantidad);
	}
}