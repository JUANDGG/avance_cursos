package com.estudio.seguridadConJwt.pojo.DTO;

import com.estudio.seguridadConJwt.models.PermissionModel;
import com.estudio.seguridadConJwt.models.RoleModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PermissionDto {
    private Long roleId ;
    private String name;

    public static PermissionDto toDto (PermissionModel permissionModel){
        return PermissionDto.builder()
        .name(permissionModel.getName())
        .roleId(permissionModel.getRole().getId())
        .build();
    }

   public static PermissionModel toModel(PermissionDto permissionDto, RoleModel roleModel) {
        return PermissionModel.builder()
                .name(permissionDto.getName())
                .role(roleModel) 
                .build();
    }
}
