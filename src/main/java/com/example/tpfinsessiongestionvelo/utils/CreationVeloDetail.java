package com.example.tpfinsessiongestionvelo.utils;

import com.example.tpfinsessiongestionvelo.entities.VeloDetail;
import lombok.Data;

import java.util.ArrayList;
@Data
public class CreationVeloDetail {
    private ArrayList<VeloDetail> veloDetails;
    public CreationVeloDetail() {
        veloDetails = new ArrayList<>();
        VeloDetail veloDetail1 = new VeloDetail(10.5, "Vélo tout-terrain agile et léger, parfait pour les sentiers étroits et techniques.", 1500.0, 50.0);
        VeloDetail veloDetail2 = new VeloDetail(9.8, "Vélo tout-terrain rapide et puissant, idéal pour les descentes et les sauts.", 1800.0, 40.0);
        VeloDetail veloDetail3 = new VeloDetail(11.2, "Vélo tout-terrain agile et léger, parfait pour les sentiers étroits et techniques.", 1400.0, 45.0);
        VeloDetail veloDetail4 = new VeloDetail(10.9, "Vélo tout-terrain haut de gamme en édition limitée, avec des composants de qualité supérieure.", 2000.0, 35.0);
        VeloDetail veloDetail5 = new VeloDetail(9.5, "Vélo tout-terrain agressif et dynamique, conçu pour les compétitions et les performances extrêmes.", 1700.0, 55.0);
        VeloDetail veloDetail6 = new VeloDetail(9.3, "Vélo tout-terrain fluide et réactif, offrant une conduite en douceur sur tous les types de terrains.", 1600.0, 42.0);
        VeloDetail veloDetail7 = new VeloDetail(10.7, "Vélo tout-terrain élégant et robuste, doté d'une suspension avancée pour une absorption optimale des chocs.", 1900.0, 48.0);
        VeloDetail veloDetail8 = new VeloDetail(11.5, "Vélo tout-terrain surpuissant et résistant, conçu pour affronter les conditions les plus extrêmes.", 2200.0, 38.0);
        VeloDetail veloDetail9 = new VeloDetail(9.9, "Vélo tout-terrain polyvalent et confortable, idéal pour les longues randonnées et les aventures en pleine nature.", 1500.0, 47.0);
        VeloDetail veloDetail10 = new VeloDetail(10.1, "Vélo tout-terrain agile et léger, parfait pour les sentiers étroits et techniques.", 1400.0, 45.0);

        veloDetails.add(veloDetail1);
        veloDetails.add(veloDetail2);
        veloDetails.add(veloDetail3);
        veloDetails.add(veloDetail4);
        veloDetails.add(veloDetail5);
        veloDetails.add(veloDetail6);
        veloDetails.add(veloDetail7);
        veloDetails.add(veloDetail8);
        veloDetails.add(veloDetail9);
        veloDetails.add(veloDetail10);

    }


}
