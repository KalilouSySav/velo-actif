package com.example.tpfinsessiongestionvelo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Data
@ToString(exclude = "velos")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "accessoire")
public class Accessoire {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NonNull
    @Column(name = "nom")
    private String nom;
    @NonNull
    @Column(name = "description")
    private String description;
    @NonNull
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "supprimer", columnDefinition = "boolean default false")
    private boolean supprimer;

    //private double prix;
    @JsonIgnore
    @ManyToMany(mappedBy = "accessoires", cascade = CascadeType.ALL)
    private List<Velo> velos;

    public void addVelo(Velo velo) {
        if (velos == null) {
            velos = new java.util.ArrayList<>();
        }
        velos.add(velo);
    }

}
