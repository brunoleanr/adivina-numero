package com.jona.adivinanumero.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jona.adivinanumero.util.JsonUtil;

@RestController
@RequestMapping("apiServiceDemo")
public class ApiServiceDemo {

	@Autowired
	private ApiEjb apiEjb;

	@GetMapping("/metodoSimple")
	public String metodoSimple() {
		return "METODO GET SIMPLE";
	}

	@GetMapping("/metodoGet")
	public String metodoGet(@RequestParam("data") String data) {
		return "METODO GET - " + data;
	}

	@GetMapping("/metodoGetOblig/{data}")
	public String metodoGetOblig(@PathVariable("data") String data) {
		return "METODO GET CON PARAMETRO OBLIGATORIO - " + data;
	}

	@PostMapping("/metodoPost")
	public String despedir(@RequestBody String data) throws IOException {
		return "METODO POST - " + JsonUtil.getStringValue(data, "dato");
	}

	@GetMapping("/metodoEjb")
	public String metodoEjb() {
		return apiEjb.getSaludo();
	}

}
