package com.estudio.seguridadConJwt.pojo.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.estudio.seguridadConJwt.models.PermissionModel;
import com.estudio.seguridadConJwt.models.RoleEnum;
import com.estudio.seguridadConJwt.models.RoleModel;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    private String  nameRole ;
    private List<PermissionDto>permission ;


    public static RoleDto toDto (RoleModel roleModel){
        return RoleDto.builder()
                .nameRole(roleModel.getRoleEnum().name())
                .permission(roleModel.getPermission().stream().map(PermissionDto::toDto).collect(Collectors.toList()))
                .build();
    }


    public static RoleModel toModel(RoleDto roleDto) {
        RoleModel roleModel = RoleModel.builder()
                .roleEnum(RoleEnum.valueOf(roleDto.getNameRole()))
                .build();

        // convertimos los permisos y asignamos la relación
        List<PermissionModel> permissions = roleDto.getPermission().stream()
                .map(permissionDto -> PermissionDto.toModel(permissionDto, roleModel))
                .collect(Collectors.toList());

        roleModel.setPermission(permissions);
        return roleModel;
    }

}
