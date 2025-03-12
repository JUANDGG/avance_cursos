package com.avance.cursoBasico.manejoExepciones.ExepcionesEnControladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping("/test-controller")
    public int testController() {
        return 100/0;
    }
}
