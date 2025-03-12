package com.avance.cursoBasico.pojo;

import com.avance.cursoBasico.models.PasswordModel;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class PasswordDto {
    private String nameSite;
    private String password;

    public static PasswordDto toDto(PasswordModel passwordModel) {
        return PasswordDto.builder()
                .nameSite(passwordModel.getNameSite())
                .password(passwordModel.getPassword())
                .build();
    }

    public static PasswordModel toModel (PasswordDto passwordDto) {
        return  PasswordModel.builder()
                .nameSite(passwordDto.getNameSite())
                .password(passwordDto.getPassword())
                .build();
    }



}
