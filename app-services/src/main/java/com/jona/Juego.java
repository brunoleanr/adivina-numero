package com.jona;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jona.entity.Usuario;

@ApplicationScoped // Esto va antes de crear la clase
public class Juego {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(Juego.class);

	private Integer nVidas = 0;
	private int nVidasOriginales = 0;
	private int record = 0;

	@Inject
	private EntityManager entityManager;

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

	@SuppressWarnings("unchecked")
	public String getUserName(Boolean usaEntidad) {

		String nombre = null;

		if (usaEntidad) {
			String query = "SELECT * FROM usuario WHERE id = 1";

			Query nativeQuery = entityManager.createNativeQuery(query);

			List<Object[]> resultList = (List<Object[]>) nativeQuery.getResultList();

			for (Object[] array : resultList) {
				nombre = (String) array[1];
			}

		} else {
			nombre = entityManager.find(Usuario.class, 1L).getNombre();
		}

		return nombre;

	}

}
