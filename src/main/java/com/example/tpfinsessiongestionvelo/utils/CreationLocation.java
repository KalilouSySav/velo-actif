package com.example.tpfinsessiongestionvelo.utils;

import com.example.tpfinsessiongestionvelo.entities.Location;
import lombok.Data;

import java.util.ArrayList;
@Data
public class CreationLocation {
    private ArrayList<Location> locationList;
    public CreationLocation(){
        ArrayList<Location> locationList = new ArrayList<>();

        Location location1 = new Location("14:00", "15:00");
        Location location2 = new Location("15:00", "16:00");
        Location location3 = new Location("16:00", "17:00");
        Location location4 = new Location("17:00", "18:00");
        Location location5 = new Location("18:00", "19:00");
        Location location6 = new Location("6:00", "8:00");
        Location location7 = new Location("8:00", "10:00");
        Location location8 = new Location("10:00", "12:00");
        Location location9 = new Location("12:00", "14:00");
        Location location10 = new Location("10:00", "20:00");

        locationList.add(location1);
        locationList.add(location2);
        locationList.add(location3);
        locationList.add(location4);
        locationList.add(location5);
        locationList.add(location6);
        locationList.add(location7);
        locationList.add(location8);
        locationList.add(location9);
        locationList.add(location10);

        this.locationList = locationList;
    }
}
