package com.proxym.gestionastreintes.repository;

import com.proxym.gestionastreintes.enumuration.StatusdemandeEnum;
import com.proxym.gestionastreintes.model.Demandeastreinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeastreinteRepository extends JpaRepository<Demandeastreinte, Long> {

    Optional<Demandeastreinte> findById(Long idcollab);

    @Query("select demandeastreinte from Demandeastreinte demandeastreinte where demandeastreinte.collaborateur.id like :idcollab")
    List<Demandeastreinte> findDemandeastreinteByCollaborateurId(@Param("idcollab") long idcollab);



}
