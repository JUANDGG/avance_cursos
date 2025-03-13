package com.estudio.seguridadConJwt.Service;

import com.estudio.seguridadConJwt.pojo.DTO.UserDto;
import java.util.List;

public interface UserService {
    public List<UserDto>getAllUser();
    public UserDto getUserById(Long id);
    public UserDto saveUser(UserDto userDto);
} 
