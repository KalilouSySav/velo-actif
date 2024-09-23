package com.example.tpfinsessiongestionvelo.utils;

import com.example.tpfinsessiongestionvelo.entities.Velo;
import lombok.Data;

import java.util.ArrayList;
@Data
public class CreationVelo {
    private ArrayList<Velo> veloList;
    public CreationVelo() {
        this.veloList = new ArrayList<Velo>();

        Velo velo1 = new Velo("Firestorm", "VTT", "Flamme", "M", 2023, "Inferno Cycles");
        Velo velo2 = new Velo("Silver Bullet", "VTT", "Argent", "L", 2023, "Silver Cycles");
        Velo velo3 = new Velo("Ultraviolet Genesis", "VTT", "Violet", "S", 2023, "Purple Cycles");
        Velo velo4 = new Velo("Golden Stallion", "VTT", "Or", "XL", 2023, "Golden Cycle Co.");
        Velo velo5 = new Velo("Crimson Fury", "VTT", "Rouge Flamboyant", "M", 2023, "Blaze Bicycles");
        Velo velo6 = new Velo("Oceanic Wave", "VTT", "Bleu Océan", "L", 2023, "Aqua Rides");
        Velo velo7 = new Velo("Emerald Glide", "VTT", "Émeraude", "S", 2023, "Gems on Wheels");
        Velo velo8 = new Velo("Solar Flare", "VTT", "Jaune Solaire", "XL", 2023, "Solar Cycle Works");
        Velo velo9 = new Velo("Ruby Racer", "VTT", "Rouge Rubis", "M", 2023, "Gemstone Bicycles");
        Velo velo10 = new Velo("Midnight Eclipse", "VTT", "Noir", "L", 2023, "Eclipse Bikes");

        this.veloList.add(velo1);
        this.veloList.add(velo2);
        this.veloList.add(velo3);
        this.veloList.add(velo4);
        this.veloList.add(velo5);
        this.veloList.add(velo6);
        this.veloList.add(velo7);
        this.veloList.add(velo8);
        this.veloList.add(velo9);
        this.veloList.add(velo10);
    }
}
