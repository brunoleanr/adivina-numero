package com.jona.adivinanumero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jona.adivinanumero.api.ApiEjb;

@Configuration
@ComponentScan(value = { "com.jona.adivinanumero.api" })
public class Config {

	@Bean
	public ApiEjb getApiEjb() {
		return new ApiEjb();
	}

}
