package com.estudio.seguridadConJwt.models;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleEnum {
    ROLE_ADMIN, ROLE_CLIENT;

    @JsonCreator
    public static RoleEnum fromString(String value) {
        return RoleEnum.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return name();
    }
}
