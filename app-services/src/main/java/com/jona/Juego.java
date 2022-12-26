package com.jona;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped // Esto va antes de crear la clase
public abstract class Juego {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(Juego.class);

	private Integer nVidas = 0;
	private int nVidasOriginales = 0;
	private int record = 0;

	// MEtodo mostrar vidas restantes
	public String muestraVidasRestantes() {
		return "Nuemero de vidas: " + nVidas;
	}

	// Metodo quietar vidas:
	public boolean quitarVidas() {
		nVidas = nVidas - 1;
		LOG.info("quitarvidas - " + nVidas.toString());
		if (nVidas > 0) {
			return true;
		} else {
			return false;
		}

	}

	// Metodo reiniciarPartida:
	public void reiniciarPartida() {
		this.nVidas = nVidasOriginales;
	}

	// Metodo ActualizarRecord:
	public String actualizarRecord() {
		if (nVidas == record) {
			return "Ha alcanzado el record";
		} else if (nVidas > record) {
			record = nVidas;
			return "El record a sido superado" + record;
		} else {
			return null;
		}
	}

	public int getnVidas() {
		return nVidas;
	}

	public void setnVidas(Integer nVidas) {
		LOG.info("Setnvidas - " + nVidas.toString());
		this.nVidas = nVidas;
		this.nVidasOriginales = nVidas;
	}

}
