package com.estudio.seguridadConJwt.models;

import jakarta.persistence.CascadeType;
//jakarta se usa en spring en versiones nuevas de spring , para versiones antiguas se usa javax
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import java.util.List;

// Un record no permite atributos mutables como List<Permission>
@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;

    @Column(name = "role_name",unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum ;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<PermissionModel>permission ;

}
