package com.estudio.seguridadConJwt.pojo.DTO.role;
import java.util.List;


import com.estudio.seguridadConJwt.pojo.DTO.PermissionDto;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class RoleDto {
    @JsonView(RoleView.Name.class)
    private String  nameRole ;

    @JsonView(RoleView.PermissionsAndName.class)
    private List<PermissionDto>permission ;
}
