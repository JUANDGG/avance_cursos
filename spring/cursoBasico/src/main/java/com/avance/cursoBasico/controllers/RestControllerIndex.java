package com.avance.cursoBasico.controllers;


import com.avance.cursoBasico.models.UserModel;
import com.avance.cursoBasico.pojo.UserDto;
import com.avance.cursoBasico.servicesRest.UserRepository;
import com.avance.cursoBasico.servicesRest.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
@RestController
//si queremos podemos no poner la ruta para los enpoints pero es nesesario ya que se aclara mejor
@RequestMapping("/api/v1/return")
public class RestControllerIndex {

    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepository;

    @Autowired
    public RestControllerIndex(UserServiceImpl userServiceImpl, UserRepository userRepository) {
        this.userServiceImpl = userServiceImpl;
        this.userRepository = userRepository;
    }

    @GetMapping("/home-two")
    public Map<String, Object> homeTwo() {

        Map<String, Object> model = new HashMap<>();
        model.put("message", "Hello World!");
        return model;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userServiceImpl.getAllUsers());
    }


    @PostMapping("/user")
    public void saveUser(@RequestBody UserDto userDto) {
        userServiceImpl.save(userDto);
    }

}
