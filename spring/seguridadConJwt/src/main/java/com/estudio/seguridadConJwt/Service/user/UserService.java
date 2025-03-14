package com.estudio.seguridadConJwt.Service.user;

import com.estudio.seguridadConJwt.models.UserModel;
import com.estudio.seguridadConJwt.pojo.DTO.UserDto;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserDto>getAllUser();
    public UserDto getUserById(Long id);
    public UserDto saveUser(UserDto userDto);
    public UserDto editUser(Long id ,UserDto userDto);
    public void deleteUser(Long id);

} 
