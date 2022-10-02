package com.proxym.gestionastreintes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxym.gestionastreintes.enumuration.StatusdemandeEnum;
import com.proxym.gestionastreintes.enumuration.TypedemandeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demandeastreinte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TypedemandeEnum typedemande;
    private StatusdemandeEnum statusdemande;
    private String commentaire;

    @ManyToOne
    private Astreinte astreinte;
    @JsonIgnore
    @ManyToOne
    private Collaborateur collaborateur;

    @OneToOne
    private Historique historique;

}
