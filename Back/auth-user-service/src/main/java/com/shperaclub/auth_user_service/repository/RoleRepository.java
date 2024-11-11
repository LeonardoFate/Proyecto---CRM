package com.shperaclub.auth_user_service.repository;

import com.shperaclub.auth_user_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role, Long> {

    //Encontrar rol por su nombre
    Optional<Role> findByName(String name);
}
