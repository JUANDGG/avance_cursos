package com.avance.cursoBasico.pojo;



import com.avance.cursoBasico.models.UserModel;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDto {
    private String name ;
    private String email;
    private String password;

    //mappers
    public  static UserDto toDto (UserModel userModel){
        return UserDto.builder()
                .name(userModel.getName())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .build();
    }

    public  static UserModel toModel (UserDto useDto){
        return new UserModel().builder()
                .name(useDto.getName())
                .email(useDto.getEmail())
                .password(useDto.getPassword())
                .build();
    }
}
