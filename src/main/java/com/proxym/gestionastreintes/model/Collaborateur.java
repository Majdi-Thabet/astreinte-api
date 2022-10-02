package com.proxym.gestionastreintes.model;

import com.proxym.gestionastreintes.enumuration.SexeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collaborateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String password;
    private String poste;
    private SexeEnum sexe;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @ManyToOne
    private Departement department;

    @OneToMany
    private Collection<Configastreinte> configastreintes = new ArrayList<>();

    @OneToMany
    private Collection<Astreinte> astreintes = new ArrayList<>();

    @OneToMany(mappedBy = "collaborateur", orphanRemoval = true)
    private Collection<Demandeastreinte> demandeastreintes = new ArrayList<>();
}
