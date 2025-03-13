package com.estudio.seguridadConJwt.Service;

import com.estudio.seguridadConJwt.models.RoleModel;
import com.estudio.seguridadConJwt.pojo.DTO.RoleDto;
import com.estudio.seguridadConJwt.repositories.RoleRepository;


import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    
    private final RoleRepository roleRepository ;


    public RoleServiceImpl(RoleRepository roleRepository ){
        this.roleRepository =roleRepository;
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {    
        RoleModel roleModel = RoleDto.toModel(roleDto);
    
        if (roleModel.getId() == null) {
            roleModel = roleRepository.save(roleModel);
        }
      
        return RoleDto.toDto(roleModel);
    }
    
    
}
