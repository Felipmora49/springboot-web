package com.felipmora47.curso.springboot.webapp.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.PropertySources;

@SpringBootApplication

// Agregar varios archivos de propiedades con PropertySources
/* @PropertySources({
	@PropertySource("classpath:values2.properties"),
	@PropertySource("classpath:values3.properties")
}) */

public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
