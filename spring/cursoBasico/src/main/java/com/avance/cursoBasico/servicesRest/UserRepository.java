package com.avance.cursoBasico.servicesRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.avance.cursoBasico.models.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


    UserModel findByEmail(String email);
}
