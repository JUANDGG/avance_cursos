package com.estudio.seguridadConJwt.pojo.DTO;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserRoleDto {    
    private Long userId;


    private Long roleId;

}
