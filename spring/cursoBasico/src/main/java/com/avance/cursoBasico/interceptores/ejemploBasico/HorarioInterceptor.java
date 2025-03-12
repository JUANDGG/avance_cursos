package com.avance.cursoBasico.interceptores.ejemploBasico;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesa-ayuda")
public class HorarioInterceptor {
    @GetMapping
    public String horario() {
        return "Bienvenid  a de Mesa ayuda";
    }
}
