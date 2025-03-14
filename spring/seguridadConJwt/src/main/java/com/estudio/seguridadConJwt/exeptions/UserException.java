package com.estudio.seguridadConJwt.exeptions;


public class UserException extends  RuntimeException{
    public UserException(UserExeptionErrors userExeptionErrors) {
        super(userExeptionErrors.getMessage());
    }
}
