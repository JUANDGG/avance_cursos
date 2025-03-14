package com.estudio.seguridadConJwt.Service.roles;

import com.estudio.seguridadConJwt.pojo.DTO.role.RoleDto;
import java.util.List;

public interface RoleService {
    public List<RoleDto> getAllRole();
    public RoleDto getRoleById(Long id);
    public RoleDto saveRole(RoleDto roleDto);
    public RoleDto editRole(Long id,RoleDto roleDto);
    public void deleteRole (Long id) ;
    
}