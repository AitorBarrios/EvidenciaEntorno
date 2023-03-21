package Main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuentaBancaria cb = new CuentaBancaria();
		try {
			cb.agregarSaldo(3000);
			cb.agregarSaldo(2000);
			cb.retirarSaldo(1000);
			cb.agregarSaldo(500);
			//cb.retirarSaldo(150);
			//cb.obtenerSaldo()//debe retornar 150
			//cb.modificarCredito(1000);
			cb.solicitarPrestamo(12000);
			cb.obtenerPrestamo();//debe retornar 450
		} catch (Exception e) {
		}
	}

}
