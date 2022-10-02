package com.proxym.gestionastreintes.repository;

import com.proxym.gestionastreintes.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
