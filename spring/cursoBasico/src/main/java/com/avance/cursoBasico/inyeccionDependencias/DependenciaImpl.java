package com.avance.cursoBasico.inyeccionDependencias;

import org.springframework.stereotype.Component;

@Component
public class DependenciaImpl implements  Dependecia{
    @Override
    public void define() {
        System.out.println("define");
    }
}
