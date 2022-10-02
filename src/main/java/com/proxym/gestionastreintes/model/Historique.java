package com.proxym.gestionastreintes.model;

import com.proxym.gestionastreintes.enumuration.StatusdemandeEnum;
import com.proxym.gestionastreintes.enumuration.TypedemandeEnum;
import com.proxym.gestionastreintes.enumuration.TypeinterventionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TypeinterventionEnum typeintervention;

    @OneToOne
    private Demandeastreinte demandeastreinte;

}
