package com.avance.cursoBasico.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name ;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "userModel" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<PasswordModel> passwordModelList;

}
