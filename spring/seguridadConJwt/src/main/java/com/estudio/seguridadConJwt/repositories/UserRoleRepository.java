package com.estudio.seguridadConJwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudio.seguridadConJwt.models.UserRoleModel;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleModel,Long>{

} 
