package com.example.tpfinsessiongestionvelo.utils;

import com.example.tpfinsessiongestionvelo.entities.LigneLocation;
import com.example.tpfinsessiongestionvelo.entities.Velo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CreationLigneLocation {
    private ArrayList<LigneLocation> ligneLocationList;
    public CreationLigneLocation() {

        ArrayList<LigneLocation> ligneLocationList = new ArrayList<>();

        LigneLocation ligneLocation1 = new LigneLocation(1,6);
        LigneLocation ligneLocation2 = new LigneLocation(3,15);
        LigneLocation ligneLocation3 = new LigneLocation(6,50);
        LigneLocation ligneLocation4 = new LigneLocation(2,10);
        LigneLocation ligneLocation5 = new LigneLocation(4,20);
        LigneLocation ligneLocation6 = new LigneLocation(5,30);
        LigneLocation ligneLocation7 = new LigneLocation(7,70);
        LigneLocation ligneLocation8 = new LigneLocation(8,80);
        LigneLocation ligneLocation9 = new LigneLocation(9,90);
        LigneLocation ligneLocation10 = new LigneLocation(10,100);

        ligneLocationList.add(ligneLocation1);
        ligneLocationList.add(ligneLocation2);
        ligneLocationList.add(ligneLocation3);
        ligneLocationList.add(ligneLocation4);
        ligneLocationList.add(ligneLocation5);
        ligneLocationList.add(ligneLocation6);
        ligneLocationList.add(ligneLocation7);
        ligneLocationList.add(ligneLocation8);
        ligneLocationList.add(ligneLocation9);
        ligneLocationList.add(ligneLocation10);

        this.ligneLocationList = ligneLocationList;


    }
}
