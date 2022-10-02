package com.proxym.gestionastreintes.repository;

import com.proxym.gestionastreintes.model.Astreinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AstreinteRepository extends JpaRepository<Astreinte,Long> {
    Optional<Astreinte> findById(Long idcollab);

    @Query("select astreinte from Astreinte astreinte where astreinte.collaborateur.id like :idcollab")
    List<Astreinte> findAstreinteByCollaborateurId(@Param("idcollab") long idcollab);

}
