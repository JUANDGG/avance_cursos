package com.authentication.persistence.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name = "role")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;
    
    @Column(name = "role",nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum ;

    @ManyToMany(fetch =FetchType.EAGER , cascade =  CascadeType.ALL)
    @JoinTable (
        name = "role_permission",
        joinColumns =  @JoinColumn(name = "id_role"),
        inverseJoinColumns = @JoinColumn(name = "id_permission")
    )
    private Set<PermissionEntity>  permissionEntity ;


    public RoleEntity(String name ,Set<PermissionEntity>permissions){

    }
}
