package com.shperaclub.auth_user_service.repository;

import com.shperaclub.auth_user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Buscar usuario por nombre
    Optional<User> findByUsername(String username);

    //Nombre con el mismo user existe
    boolean existsByUsername(String username);

    //Usuario email existente
    boolean existsByEmail(String email);
}
