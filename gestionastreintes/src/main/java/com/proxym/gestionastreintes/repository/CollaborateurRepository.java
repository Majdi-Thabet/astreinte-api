package com.proxym.gestionastreintes.repository;

import com.proxym.gestionastreintes.model.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CollaborateurRepository  extends JpaRepository<Collaborateur,Long> {


    public Collaborateur findByUsername(String username) ;
    @Query("select collaborateur from Collaborateur collaborateur  JOIN collaborateur.roles  role where  role.roleName  like 'USER'  " +
            "and collaborateur.department.id like :iddepartment")
    List<Collaborateur> getcollabwithroleuseranddepartment(@Param("iddepartment") long iddepartment);



}
