package com.example.tpfinsessiongestionvelo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@ToString(exclude = "velo")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name="velo_detail")
public class VeloDetail {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @NonNull
    @Column(name="poids")
    private double poids;
    @NonNull
    @Column(name="description")
    private String description;
    @NonNull
    @Column(name="prix_achat")
    private double prixAchat;
    @NonNull
    @Column(name="prix_location")
    private double prixLocation;
    @Column(name="supprimer", columnDefinition = "boolean default false")
    private boolean supprimer;

    @JsonIgnore
    @OneToOne(mappedBy = "veloDetail")
    private Velo velo;

}
