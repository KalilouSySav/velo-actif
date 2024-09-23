package com.example.tpfinsessiongestionvelo.controlleur;

import com.example.tpfinsessiongestionvelo.entities.Location;
import com.example.tpfinsessiongestionvelo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationControlleur {
    private LocationService locationService;
    @Autowired
    public LocationControlleur(LocationService locationService) {
        this.locationService = locationService;
    }

    @DeleteMapping("/location/{id}")
    public boolean deleteLocationById(@PathVariable int id) {
        return locationService.deleteLocationById(id);
    }

    @GetMapping("/location/id/{id}")
    public List<Location> findLocationByIdGreaterThanOrderByIdDesc(@PathVariable int id) {
        return locationService.findLocationByIdGreaterThanOrderByIdDesc(id);
    }

    @GetMapping("/locations/cleint/{id}")
    public List<Location> findAllByClientId(@PathVariable int id) {
        return locationService.findAllByClientId(id);
    }

}
