package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Client;
import com.example.tpfinsessiongestionvelo.entities.Location;
import com.example.tpfinsessiongestionvelo.repository.LigneLocationRepository;
import com.example.tpfinsessiongestionvelo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{
   private LocationRepository locationRepository;
   @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
       this.locationRepository = locationRepository;
   }


    @Override
    public List<Location> findAllByClientId(int id) {
       List<Location> locations = null;
       if (id > 0 && locationRepository.existsByClientId(id)) {
            return locationRepository.findAllByClientId(id);
        }
        return locations;
    }

    @Override
    public boolean deleteLocationById(int id) {
        if (id > 0 && locationRepository.existsById(id)) {
            Location location = locationRepository.findById(id).get();
            location.setSupprimer(true);
            locationRepository.save(location);
            return true;
        }
        return false;
    }

    @Override
    public List<Location> findLocationByIdGreaterThanOrderByIdDesc(int id) {
        List<Location> locations = null;
        if (id > 0) {
            locations = locationRepository.findLocationByIdGreaterThanOrderByIdDesc(id);
        }
        return locations;
    }
}
