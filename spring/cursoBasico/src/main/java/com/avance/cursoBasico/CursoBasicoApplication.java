package com.avance.cursoBasico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

//ESTO SOLO FUNCIONA PARA PROPERTIES
/*
*@PropertySource(ClassPath:"nombre del properties") : esta es una manera de traer por ejemplo otro aplication.properties
*
* //podemos tener varios por ejemplo
*
* @PropertySources({
* 		//PARA MANEJAR ASENTOS EN EL PROPERTIES
* 		@PropertySource(ClassPath:"nombre1",enconding="UTF-8")
		@PropertySource(ClassPath:"nombre2")
* })
* */
public class CursoBasicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoBasicoApplication.class, args);
	}

}
