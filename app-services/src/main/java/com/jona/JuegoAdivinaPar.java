package com.jona;

public class JuegoAdivinaPar extends JuegoAdivinaNumero {

	public JuegoAdivinaPar(int nVidas, int numAdivinar) {
		super(nVidas, numAdivinar);
	}
	
	public boolean validaNumero(int numero) {
		if (numero %2==0 && numero <=10 && numero >=0) {
			return true;
		} else {
			return false;
		}
	}
	


}
