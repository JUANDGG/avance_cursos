package com.estudio.seguridadConJwt.Service.roles.impl;


import com.estudio.seguridadConJwt.Service.roles.RoleService;
import com.estudio.seguridadConJwt.models.RoleEnum;
import com.estudio.seguridadConJwt.models.RoleModel;
import com.estudio.seguridadConJwt.pojo.DTO.role.RoleDto;
import com.estudio.seguridadConJwt.pojo.mappers.RoleMapper;
import com.estudio.seguridadConJwt.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository ;
    public RoleServiceImpl(RoleRepository roleRepository ){
        this.roleRepository =roleRepository;
    }

    @Override
    public List<RoleDto> getAllRole() {
        List<RoleDto> getAllRoleDto = (roleRepository.findAll()).stream().map(RoleMapper::toDto).collect(Collectors.toList());
        return getAllRoleDto;
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Optional<RoleModel> roleModel = roleRepository.findById(id);

        if(roleModel.isEmpty()){
            //manejar errores
            return null;
        }

        RoleDto roleDto = RoleMapper.toDto(roleModel.get());

        return  roleDto;
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Optional<RoleModel> roleModelForName  =
                roleRepository.findByRoleEnum(RoleEnum.valueOf(roleDto.getNameRole()));

        if(roleModelForName.isPresent()){
            return null ;
        }

        RoleModel roleModel = RoleMapper.toModel(roleDto);
        roleRepository.save(roleModel);
        return roleDto;
    }

    @Override
    public RoleDto editRole(Long id, RoleDto roleDto) {
        Optional<RoleModel> roleModel = roleRepository.findById(id);

        if(roleModel.isEmpty()){
            return null ;
        }

        roleModel.get().getRoleEnum()

    }

    @Override
    public void deleteRole(Long id) {

    }


}
