package com.jona;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JuegoAdivinaNumero extends Juego implements Jugable {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(JuegoAdivinaNumero.class);

	private int numAdivinar;

	public JuegoAdivinaNumero(int nVidas, int numAdivinar) {

		this.setnVidas(nVidas);
		this.setnumeroAdivinar(numAdivinar);
	}

	// Implementa el método Juega de la clase base:
	public String juega(Integer numero) {

		if (validaNumero(numero) == false) {
			return "Numero incorrecto ingrese otro numero";
		}

		if (numero == numAdivinar) {
			this.actualizarRecord();
			return "acertaste";
		} else {

			if (quitarVidas() == true) {

				if (numero > numAdivinar) {
					return "Es mayor, elegi otro numero";
				} else {
					return "Es menor, elegi otro numero";
				}
			} else {
				LOG.info("juego finalizado - " + numero.toString());
				return "Juego finalizazdo";
			}
		}

	}

	public void setnumeroAdivinar(int numero) {
		this.numAdivinar = numero;
	}

	public boolean validaNumero(int numero) {
		return true;
	}

	public void juega() {

	}

	public String muestraNombre() {
		return "Adivina un número";

	}

	public void muestraInfo() {

	}

}
