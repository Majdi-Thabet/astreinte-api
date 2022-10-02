package com.proxym.gestionastreintes.repository;

import com.proxym.gestionastreintes.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {
    Departement findByDepartementName(String departementName);
}
