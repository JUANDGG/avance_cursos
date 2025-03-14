package com.estudio.seguridadConJwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudio.seguridadConJwt.Service.roles.RoleService;
import com.estudio.seguridadConJwt.pojo.DTO.role.RoleDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    
    private final RoleService roleService ;

    public RoleController(RoleService roleService){
        this.roleService = roleService ;
    }


    @PostMapping
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto) {
        return ResponseEntity.ok(roleService.saveRole(roleDto));
    }
    

}
