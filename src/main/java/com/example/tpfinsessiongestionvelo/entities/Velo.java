package com.example.tpfinsessiongestionvelo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;   //utiliser lombok pour velo seulement

import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@ToString(exclude = {"accessoires", "ligneLocations", "veloDetail"})
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "velo")
public class Velo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name="nom")
    private String nom;
    @NonNull
    @Column(name = "type")
    private String type;
    @NonNull
    @Column(name = "couleur")
    private String couleur;
    @NonNull
    @Column(name="taille")
    private String taille;
    @NonNull
    @Column(name = "annee")
    private int annee;
    @NonNull
    @Column(name = "fabricant")
    private String fabricant;
    @Column(name = "supprimer", columnDefinition = "boolean default false")
    private boolean supprimer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "velo_detail_id")
    private VeloDetail veloDetail;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(name = "velo_accessoire",
            joinColumns = @JoinColumn(name = "velo_id"),
            inverseJoinColumns = @JoinColumn(name = "accessoire_id"))
    private List<Accessoire> accessoires;

    @JsonIgnore
    @OneToMany(mappedBy = "velo", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<LigneLocation> ligneLocations;
    public void addAccessoire(Accessoire accessoire) {

        if (accessoires == null) {
            accessoires = new java.util.ArrayList<>();
        }
        accessoires.add(accessoire);
    }



}
