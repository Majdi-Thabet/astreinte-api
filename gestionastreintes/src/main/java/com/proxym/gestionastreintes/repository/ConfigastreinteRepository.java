package com.proxym.gestionastreintes.repository;

import com.proxym.gestionastreintes.model.Collaborateur;
import com.proxym.gestionastreintes.model.Configastreinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sun.security.krb5.Config;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigastreinteRepository extends JpaRepository<Configastreinte,Long> {
//    Configastreinte findByConfigastreinteName(String configastreintetName);
//Optional<Demandeastreinte> findById(Long idcollab);
Optional<Configastreinte> findById(Long idcollabadmin);





}




