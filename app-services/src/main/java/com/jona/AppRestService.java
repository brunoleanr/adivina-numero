package com.jona;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jona.config.Config;
import com.jona.entity.Usuario;

@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ "*/*" })
@Path("/")
public class AppRestService {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AppRestService.class);
	
	@Inject
	private UsuarioEjb usuarioEjb;
	
	@GET
	@Path("/usuario")
	public Usuario usuarioEjb() {
		return usuarioEjb.getUsuario();
	}

	@GET
	@Path("/info")
	public String info() throws Exception {
		JsonObjectBuilder result = Json.createObjectBuilder();
		result.add("name", Config.getName());
		result.add("version", Config.getVersion());
		result.add("build.date", Config.getBuildDate());
		return result.build().toString();
	}

}