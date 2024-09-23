package com.example.tpfinsessiongestionvelo.utils;

import com.example.tpfinsessiongestionvelo.entities.Accessoire;
import lombok.Data;

import java.util.ArrayList;
@Data
public class CreationAccessoire {
    private ArrayList<Accessoire> accessoires = new ArrayList<>();
    public CreationAccessoire(){
        ArrayList<Accessoire> accessoires = new ArrayList<>();
        Accessoire accessoire1 = new Accessoire("Casque", "Casque de protection", 10);
        Accessoire accessoire2 = new Accessoire("Gants", "Gants de protection", 5);
        Accessoire accessoire3 = new Accessoire("Lunettes", "Lunettes de protection", 5);
        Accessoire accessoire4 = new Accessoire("Gilet", "Gilet de protection", 5);
        Accessoire accessoire5 = new Accessoire("Kit de réparation", "Kit de réparation", 5);
        Accessoire accessoire6 = new Accessoire("Lampe", "Lampe de poche", 3);
        Accessoire accessoire7 = new Accessoire("Pompe", "Pompe à vélo", 1);
        Accessoire accessoire8 = new Accessoire("Antivol", "Antivol", 1);
        Accessoire accessoire9 = new Accessoire("Porte-bagage", "Porte-bagage", 1);
        Accessoire accessoire10 = new Accessoire("Siège enfant", "Siège enfant", 1);

        accessoires.add(accessoire1);
        accessoires.add(accessoire2);
        accessoires.add(accessoire3);
        accessoires.add(accessoire4);
        accessoires.add(accessoire5);
        accessoires.add(accessoire6);
        accessoires.add(accessoire7);
        accessoires.add(accessoire8);
        accessoires.add(accessoire9);
        accessoires.add(accessoire10);

        this.accessoires = accessoires;

    }

}
