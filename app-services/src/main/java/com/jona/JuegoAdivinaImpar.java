package com.jona;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

	public JuegoAdivinaImpar(int nVidas, int numAdivinar) {
		super(nVidas, numAdivinar);
	}

	public boolean validaNumero(int numero) {
		if (numero % 2 != 0 && numero <= 10 && numero >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public String muestraNombre() {
		return "Adivina un número impar";
	}

	public String muestraInfo() {
		return "Instructivo";
	}

}
