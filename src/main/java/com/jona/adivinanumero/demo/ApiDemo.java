package com.jona.adivinanumero.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiDemo {

	@GetMapping("/metodoGet")
	public String metodoGet(@RequestParam("data") String data) {
		return "METODO GET " + data;
	}

	@PostMapping("/metodoPost")
	public String despedir(@RequestBody String data) {
		return "METODO POST " + data;
	}

}
