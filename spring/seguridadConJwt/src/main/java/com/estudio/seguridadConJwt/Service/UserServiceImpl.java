package com.estudio.seguridadConJwt.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.estudio.seguridadConJwt.models.RoleEnum;
import com.estudio.seguridadConJwt.models.RoleModel;
import com.estudio.seguridadConJwt.models.UserModel;
import com.estudio.seguridadConJwt.pojo.DTO.UserDto;
import com.estudio.seguridadConJwt.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> users = (userRepository.findAll()).stream().map(UserDto::toDto).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isEmpty()){
            return null ;
        }

        return UserDto.toDto(user.get()) ;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {

        UserModel userModel = UserDto.toModel(userDto);

        Optional<UserModel> userFindByEmail= userRepository.findByEmail(userDto.getEmail());

        if(userFindByEmail.isPresent()){
            return null ;
        }

        userRepository.save(userModel);

        return userDto ;
        
    }
    
   /*  @Override
    public UserDto saveUser(UserDto userDto) {
        UserModel userModel = UserDto.toModel(userDto);

        // Verificamos que los roles existen antes de asociarlos al usuario
        List<RoleModel> roles = userDto.getRole().stream()
            .map(roleDto -> roleRepository.findByRoleEnum(RoleEnum.valueOf(roleDto.getNameRole()))
                .orElseThrow(() -> new RuntimeException("El rol no existe: " + roleDto.getNameRole())))
            .collect(Collectors.toList());

        userModel.setRole(roles); // Asignamos los roles existentes

        userRepository.save(userModel);
        return UserDto.toDto(userModel);
    } */


    
    
}
