package com.authentication.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import java.util.Set;

@Table(name = "user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String userName;
    
    @Column(nullable = false)
    private String password;
    
    @Column(name = "is_enabled")
    private boolean isEnabled ;
    
    @Column(name = "account_non_expired")
    private boolean accountNonExpired ;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked ;
    
    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired ;

    //EL FETCH DE TIPO EAGER CARGA TODOS LOS DATO DE UNA NO COMO LOS LAZY 
    @ManyToMany(fetch =FetchType.EAGER , cascade =  CascadeType.ALL)
    @JoinTable (
        name = "role_user",
        joinColumns =  @JoinColumn(name = "id_user"),
        inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<RoleEntity>  roles ;

}
