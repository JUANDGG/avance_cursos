package com.avance.cursoBasico.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "password_model")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PasswordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, name = "name_site"  , nullable = false)
    private String nameSite ;
    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserModel userModel;



}
