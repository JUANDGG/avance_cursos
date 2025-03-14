package com.estudio.seguridadConJwt.pojo.mappers;

import com.estudio.seguridadConJwt.models.PermissionModel;
import com.estudio.seguridadConJwt.models.RoleModel;
import com.estudio.seguridadConJwt.pojo.DTO.PermissionDto;

public abstract class PermissionMapper {
    
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
