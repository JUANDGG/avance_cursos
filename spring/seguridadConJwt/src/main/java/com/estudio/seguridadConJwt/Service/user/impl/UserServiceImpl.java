package com.estudio.seguridadConJwt.Service.user.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.estudio.seguridadConJwt.exeptions.UserException;
import com.estudio.seguridadConJwt.exeptions.UserExeptionErrors;
import com.estudio.seguridadConJwt.pojo.DTO.UserDto;
import org.springframework.stereotype.Service;

import com.estudio.seguridadConJwt.Service.user.UserService;
import com.estudio.seguridadConJwt.models.UserModel;
import com.estudio.seguridadConJwt.pojo.mappers.UserMapper;
import com.estudio.seguridadConJwt.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> users = (userRepository.findAll()).stream().map(UserMapper::toDto).collect(Collectors.toList());
        return users;
    }


    @Override
    public UserDto getUserById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserException(UserExeptionErrors.USER_NOT_FOUND);
        }
        UserModel userModel = user.get() ;
        return UserMapper.toDto(userModel);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        Optional<UserModel> userFindByEmail= userRepository.findByEmail(userDto.getEmail());
        if(userFindByEmail.isPresent()){
            throw new UserException(UserExeptionErrors.USER_ALREADY_EXISTS);
        }
        UserModel userModel = UserMapper.toModel(userDto);
        userRepository.save(userModel);
        return userDto ;
        
    }

    @Override
    public UserDto editUser(Long id ,UserDto userDto) {
        Optional<UserModel> userFindById= userRepository.findById(id);
        if(userFindById.isEmpty()){
            throw new UserException(UserExeptionErrors.USER_NOT_FOUND);
        }
        UserModel userModel = userFindById.get();
        userModel.setEmail(userDto.getEmail());
        userModel.setPassword(userDto.getPassword());
        userRepository.save(userModel);
        return  userDto ;
    }

    @Override
    public void deleteUser(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserException(UserExeptionErrors.USER_NOT_FOUND);
        }
        UserModel userModel = user.get();
        userRepository.delete(userModel);

    }



}
