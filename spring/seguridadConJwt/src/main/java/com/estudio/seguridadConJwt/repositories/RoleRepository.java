package com.estudio.seguridadConJwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudio.seguridadConJwt.models.RoleEnum;
import com.estudio.seguridadConJwt.models.RoleModel;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel,Long>{
   Optional<RoleModel> findByRoleEnum(RoleEnum roleEnum) ;
} 
