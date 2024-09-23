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
@ToString(exclude = "locations")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name="client")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name="prenom")
    private String prenom;
    @NonNull
    @Column(name="nom")
    private String nom;
    @NonNull
    @Column(name="telephone")
    private String telephone;
    @NonNull
    @Column(name = "courriel")
    private String courriel;
    @Column(name = "supprimer", columnDefinition = "boolean default false")
    private boolean supprimer;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<Location> locations;

    public void addLocation(Location location) {
        if (locations == null) {
            locations = new java.util.ArrayList<>();
        }
        locations.add(location);
    }

}
