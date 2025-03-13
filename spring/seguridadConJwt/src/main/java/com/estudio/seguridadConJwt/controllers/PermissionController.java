package com.estudio.seguridadConJwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudio.seguridadConJwt.Service.PermissionService;
import com.estudio.seguridadConJwt.pojo.DTO.PermissionDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/permission")
public class PermissionController {
    
    private final PermissionService permissionService ;

    public PermissionController(PermissionService permissionService){
        this.permissionService =permissionService ;
    }


    @PostMapping
    public ResponseEntity<PermissionDto> savePermission(@RequestBody PermissionDto permissionDto) {
        return ResponseEntity.ok(permissionService.savePermission(permissionDto));
    }
    
}
