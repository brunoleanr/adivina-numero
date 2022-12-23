package com.jona;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jona.config.Config;

@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ "*/*" })
@Path("/api")
public class AppService {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AppService.class);

	@Inject
	private Juego juego; // Esto es igual al new de instanciamiento

	private JuegoAdivinaNumero juegaAdivinaNumero;

	@GET
	@Path("/info")
	public String info() throws Exception {
		JsonObjectBuilder result = Json.createObjectBuilder();
		result.add("name", Config.getName());
		result.add("version", Config.getVersion());
		result.add("build.date", Config.getBuildDate());
		return result.build().toString();
	}

	@GET
	@Path("/muestraVidasRestantes") // LLAmo al metodo mostrar vidas
	public String muestraVidasRestantes() {
		return juego.muestraVidasRestantes();
	}

	@GET
	@Path("/setnVidas")
	public void setnVidas(@QueryParam("vidas") int vidas) {
		juego.setnVidas(vidas);
	}

	@GET // Cada vez que llamo a un metodo agregar @get @pach
	@Path("/getnVidas")
	public int getnVidas() {
		return juego.getnVidas();
	}

	@GET
	@Path("/quitarVidas")
	public String quitarVidas() {
		boolean quitarVidas = juego.quitarVidas();
		if (quitarVidas == false) {
			return "Juego terminado";
		} else {
			return "Continua el juego";
		}
	}

	@GET
	@Path("/actualizarRecord")
	public String actualizarRecord() {
		return juego.actualizarRecord();
	}

	@GET
	@Path("/reiniciarPartida")
	public String reiniciarPartida() {
		juego.reiniciarPartida();
		return "Se reinicio la partida";
	}

	@GET
	@Path("/setnumAdivinar")
	public void setnumAdivinar(@QueryParam("numeroAdivinar") int numero) {
		juegaAdivinaNumero.setnumeroAdivinar(numero);
	}

	@GET
	@Path("/juega")
	public String juega(@QueryParam("numero") int numero) {
		return juegaAdivinaNumero.juega(numero);
	}

	@GET
	@Path("/iniciarJuegoAdivinaNumero")
	public void iniciarJuegoAdivinaNumero(@QueryParam("numAdivinar") int numAdivinar,
			@QueryParam("nVidas") Integer nVidas) {
		LOG.info("iniciar juego - " +nVidas.toString());
		juegaAdivinaNumero = new JuegoAdivinaNumero(nVidas, numAdivinar);
	}
	
	@GET
	@Path("/iniciarJuegoAdivinaPar")
	public void iniciarJuegoAdivinaPar(@QueryParam("numAdivinar") int numAdivinar,
			@QueryParam("nVidas") Integer nVidas) {
		juegaAdivinaNumero = new JuegoAdivinaPar(nVidas, numAdivinar);
	}
	
	@GET
	@Path("/iniciarJuegoAdivinaImpar")
	public void iniciarJuegoAdivinaImpar(@QueryParam("numAdivinar") int numAdivinar,
			@QueryParam("nVidas") Integer nVidas) {
		juegaAdivinaNumero = new JuegoAdivinaImpar(nVidas, numAdivinar);
	}

}
