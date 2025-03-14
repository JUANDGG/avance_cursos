package com.estudio.seguridadConJwt.pojo.DTO;
import lombok.*;


@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email ;
    private String password;
}