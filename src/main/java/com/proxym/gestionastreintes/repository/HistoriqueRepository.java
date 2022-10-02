package com.proxym.gestionastreintes.repository;

import com.proxym.gestionastreintes.model.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface HistoriqueRepository extends JpaRepository<Historique,Long> {
    Optional<Historique> findById(Long idcollab);

    @Query("select historique from Historique historique where historique.demandeastreinte.collaborateur.id like :idcollab")
    List<Historique> findHistoriqueByCollaborateurId(@Param("idcollab") long idcollab);
}
