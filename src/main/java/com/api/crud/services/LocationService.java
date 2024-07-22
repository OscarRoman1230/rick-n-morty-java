package com.api.crud.services;

import com.api.crud.models.LocationModel;
import com.api.crud.repositories.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    ILocationRepository locationRepository;

    public ArrayList<LocationModel> getAllLocations() {
        return (ArrayList<LocationModel>) locationRepository.findAll();
    }

    public Optional<LocationModel> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    public LocationModel createLocation(LocationModel location) {
        return locationRepository.save(location);
    }

    public LocationModel updateLocation(LocationModel request, Long id) {
        LocationModel location = locationRepository.findById(id).get();
        location.setName(request.getName());
        location.setType(request.getType());
        location.setDimension(request.getDimension());
        location.setUrl(request.getUrl());
        location.setCreated(request.getCreated());

        return location;
    }

    public Boolean deleteLocation(Long id) {
        try {
            locationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
