package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.CuentaBancaria;

public class Pruebas {
	
	CuentaBancaria cb = new CuentaBancaria();

	@Test
	public void testRetirarSaldo() throws Exception {
		CuentaBancaria cuenta = new CuentaBancaria();
		cuenta.agregarSaldo(300);
		cuenta.retirarSaldo(500);
	}
}
