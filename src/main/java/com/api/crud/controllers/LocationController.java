package com.api.crud.controllers;

import com.api.crud.models.LocationModel;
import com.api.crud.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public ArrayList<LocationModel> getLocations() {
        return this.locationService.getAllLocations();
    }

    @GetMapping("/location/{id}")
    public Optional<LocationModel> getLocation(@PathVariable Long id) {
        return this.locationService.getLocationById(id);
    }

    @PutMapping("/location/{id}")
    public LocationModel updateLocation(@PathVariable Long id, @RequestBody LocationModel location) {
        return this.locationService.updateLocation(location, id);
    }

    @DeleteMapping("/location/{id}")
    public String deleteLocation(@PathVariable Long id) {
        boolean result = this.locationService.deleteLocation(id);

        if (result) {
            return "Deleted location with id " + id + " successfully";
        }

        return "Not Deleted location with id " + id + " successfully";
    }
}
