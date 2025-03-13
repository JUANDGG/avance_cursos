package com.estudio.seguridadConJwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.estudio.seguridadConJwt.models.PermissionModel;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionModel,Long> {

} 
