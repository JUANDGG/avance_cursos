package com.estudio.seguridadConJwt.Service.permissions.impl;

import org.springframework.stereotype.Service;

import com.estudio.seguridadConJwt.Service.permissions.PermissionService;
import com.estudio.seguridadConJwt.models.PermissionModel;
import com.estudio.seguridadConJwt.models.RoleModel;
import com.estudio.seguridadConJwt.pojo.DTO.PermissionDto;
import com.estudio.seguridadConJwt.pojo.mappers.PermissionMapper;
import com.estudio.seguridadConJwt.repositories.PermissionRepository;
import com.estudio.seguridadConJwt.repositories.RoleRepository;


@Service
public class PermissionServiceImpl  implements PermissionService{

    private final PermissionRepository permissionRepository ;

    private final RoleRepository roleRepository ;

    public PermissionServiceImpl (PermissionRepository permissionRepository ,RoleRepository roleRepository){ 
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
     }
        
     public PermissionDto savePermission(PermissionDto permissionDto) {
    
        // buscar el RoleModel en la base de datos
        RoleModel roleModel = roleRepository.findById(permissionDto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // convertir DTO a modelo con el role obtenido
        PermissionModel permissionModel = PermissionMapper.toModel(permissionDto, roleModel);

        // Guardar en la base de datos
        permissionRepository.save(permissionModel);

        return permissionDto;
    }

     

}
