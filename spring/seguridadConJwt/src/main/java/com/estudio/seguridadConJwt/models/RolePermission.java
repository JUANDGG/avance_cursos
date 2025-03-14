package com.estudio.seguridadConJwt.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name ="role_permission")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name="id_role")
    @Column(name = "id_role",nullable = false)
    private Long idRole ;

    @ManyToOne
    @JoinColumn(name = "id_permission")
    @Column(name = "id_permission",nullable = false)
    private Long idPermission;
}
