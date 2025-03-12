package com.avance.cursoBasico.servicesRest;

import com.avance.cursoBasico.models.UserModel;
import com.avance.cursoBasico.pojo.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserDto> getAllUsers () {
        List<UserModel> users =userRepository.findAll();
        return  users.stream().map(UserDto::toDto).collect(Collectors.toList()) ;
    }

    public void save(UserDto userDto) {
         UserModel user = userRepository.findByEmail(userDto.getEmail());

         if(user != null) {
             throw new RuntimeException("User ready exists");
         }

         else {
             userRepository.save(
                     new UserModel().builder()
                         .name(userDto.getName())
                         .email(userDto.getEmail())
                        .build()
                 );
         }
    }

}
