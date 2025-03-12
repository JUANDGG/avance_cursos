package com.avance.cursoBasico.inyeccionDependencias;

import org.springframework.stereotype.Component;

//esto vuelve una clase con el patron de diseño singletos esto le dice a spring boot que lo maneje como un bean
//esto significa que va a ser manejado por el componenetes de spring
@Component
public class Componentes {
    public static void main(String[] args) {
        new Componentes();
    }
}
