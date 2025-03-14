package com.avance.cursoBasico.recorders;

import java.util.List;

/*
* un recorder se integra en versiones superiores de java pero es una forma de
* usar como una especie de lombok en clases si tener que usar lombok
* */
public record UserDto(String name, int age, List<String> data) {
}
