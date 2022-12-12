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

@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ "*/*" })
@Path("/")
public class AppService {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AppService.class);

	@Inject
	private AppEjb appEjb;

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