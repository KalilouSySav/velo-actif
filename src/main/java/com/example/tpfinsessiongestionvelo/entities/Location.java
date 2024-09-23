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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@ToString(exclude = {"client", "ligneLocations"})
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name = "date_debut")
    private String dateDebut;
    @NonNull
    @Column(name = "date_fin")
    private String dateFin;
    @Column(name = "supprimer", columnDefinition = "boolean default false")
    private boolean supprimer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private List<LigneLocation> ligneLocations;

    public void addLigneLocation(LigneLocation ligneLocation) {
        if (ligneLocations == null) {
            ligneLocations = new java.util.ArrayList<>();
        }
        ligneLocations.add(ligneLocation);
    }
}
