package com.estudio.seguridadConJwt.pojo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.estudio.seguridadConJwt.models.PermissionModel;
import com.estudio.seguridadConJwt.models.RoleEnum;
import com.estudio.seguridadConJwt.models.RoleModel;
import com.estudio.seguridadConJwt.pojo.DTO.role.RoleDto;
import com.estudio.seguridadConJwt.pojo.DTO.role.RoleView;


public abstract class RoleMapper {

    
    public static RoleDto toDto(RoleModel roleModel, Class<?> view) {
        RoleDto.RoleDtoBuilder dtoBuilder = RoleDto.builder()
                .nameRole(roleModel.getRoleEnum().name());

        
        if (view == RoleView.PermissionsAndName.class) {
            dtoBuilder.permission(roleModel.getPermission().stream()
                    .map(PermissionMapper::toDto)
                    .collect(Collectors.toList()));
        }

        return dtoBuilder.build();
    }

    public static RoleModel toModel(RoleDto roleDto ,Class<?> view ) {
        RoleModel.builder()
                    .roleEnum(RoleEnum.valueOf(roleDto.getNameRole()))
                    .build();
        

        

        if (roleDto.getPermission() != null) {
            List<PermissionModel> permissions = roleDto.getPermission().stream()
                    .map(PermissionMapper::toModel)
                    .collect(Collectors.toList());

            roleModel.setPermission(permissions);
        }

        return null;
    }
}
