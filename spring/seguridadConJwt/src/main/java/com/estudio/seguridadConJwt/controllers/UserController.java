package com.estudio.seguridadConJwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudio.seguridadConJwt.Service.UserService;
import com.estudio.seguridadConJwt.pojo.DTO.UserDto;

//esta es una libreria para validar campos en entidad hibernate
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {


 
    private final UserService userService;

    
    public UserController(UserService userService){
        this.userService = userService ;
    }


    @PostMapping
    public  ResponseEntity<UserDto>  signUp(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }
    
    
}
