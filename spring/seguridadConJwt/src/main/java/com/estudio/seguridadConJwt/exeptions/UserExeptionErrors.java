package com.estudio.seguridadConJwt.exeptions;

public enum UserExeptionErrors {
    USER_ALREADY_EXISTS("El usuario con este correo ya existe."),
    USER_NOT_FOUND("No se encontró el usuario."),
    INVALID_USER_DATA("Los datos del usuario son inválidos.");

    private final String message;

    private UserExeptionErrors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
