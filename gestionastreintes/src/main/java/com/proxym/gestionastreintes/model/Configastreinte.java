package com.proxym.gestionastreintes.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configastreinte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public int dureeconfigastreinte;
    public int periodeastreinte;
    public int nombrecollaborateurs;
    public int nombreastreintes;
    public float astreintebycollaborateur;
    public LocalDate datedebutconfig;
    public LocalDate datefinconfig;
    @OneToMany
    public List<Astreinte> astreinteList = new ArrayList<>();

//    @JsonIgnore
   @ManyToOne
    private Collaborateur collaborateur;
}



