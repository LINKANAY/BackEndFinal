package com.BackEnd.Final.repository;

import com.BackEnd.Final.models.ERole;
import com.BackEnd.Final.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

