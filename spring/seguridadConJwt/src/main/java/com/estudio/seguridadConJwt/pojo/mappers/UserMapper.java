package com.estudio.seguridadConJwt.pojo.mappers;

import com.estudio.seguridadConJwt.models.UserModel;
import com.estudio.seguridadConJwt.pojo.DTO.UserDto;

public abstract class UserMapper {

    public static UserDto toDto (UserModel userModel){
        return UserDto.builder()
        .email(userModel.getEmail())
        .password(userModel.getPassword())
        .build();
    }


    public static UserModel toModel(UserDto userDto) {
       return UserModel.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
    
} 