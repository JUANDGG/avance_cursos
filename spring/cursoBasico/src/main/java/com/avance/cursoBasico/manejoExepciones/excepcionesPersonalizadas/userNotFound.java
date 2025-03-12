package com.avance.cursoBasico.manejoExepciones.excepcionesPersonalizadas;

//estas exepciones mas que todo es en servicios que se utiliza o donde va la logica del negocio
public class userNotFound extends RuntimeException {
    public  userNotFound(String message) {
        super(message);
    }
}
