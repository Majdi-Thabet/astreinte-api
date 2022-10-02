package com.proxym.gestionastreintes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxym.gestionastreintes.enumuration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Astreinte {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String type;
  public LocalDate datedebut;
  public LocalDate datefin;
  private int dureeastreinte;
  private String datepermutation;
  private double prime;
  private String intervention;
  private StatusEnum status;
  private String raison;
  /* @JsonIgnore */
  @ManyToOne
  private Collaborateur collaborateur;
  @OneToMany
  private Collection<Demandeastreinte> demandeastreintes = new ArrayList<>();

  public void setDatefin() {

  }

  public void setDatedebut() {
  }
}
