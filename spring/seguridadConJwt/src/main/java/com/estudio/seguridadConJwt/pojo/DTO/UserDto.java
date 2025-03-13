package com.estudio.seguridadConJwt.pojo.DTO;


import com.estudio.seguridadConJwt.models.UserModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String email ;
    private String password;


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