package com.felipmora47.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// Agregar un nuevo archivo de propiedades con PropertySource en una Clase aparte de SpringbootWebApplication.java
@PropertySource(value="classpath:values.properties", encoding = "UTF-8")
public class ValueConfig {

}
