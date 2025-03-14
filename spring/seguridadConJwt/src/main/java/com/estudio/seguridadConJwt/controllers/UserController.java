package com.estudio.seguridadConJwt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.estudio.seguridadConJwt.Service.user.UserService;
import com.estudio.seguridadConJwt.pojo.DTO.UserDto;
import java.util.List;
import java.util.stream.Collectors;
//esta es una libreria para validar campos en entidad hibernate
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService ;
    }

    @GetMapping
    public ResponseEntity<List<St>> getAllUser (){
        return  ResponseEntity.ok(userService.getAllUser().stream()
                .map((usuario) -> usuario.getEmail())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById (@PathVariable Long id){
        return  ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public  ResponseEntity<UserDto>  saveUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<UserDto> editUser(@PathVariable Long id ,@RequestBody UserDto userDto){
        return  ResponseEntity.ok(userService.editUser(id,userDto));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.accepted().build();
    }
}
