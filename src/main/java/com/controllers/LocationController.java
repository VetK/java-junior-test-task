package com.controllers;

import com.dto.LocationDto;
import com.services.controllerService.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    @ResponseBody
    public LocationDto addLocationToTable(@Valid @RequestBody LocationDto locationDto){
        return locationService.saveLocation(locationDto);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public LocationDto getLocation(@Valid @PathVariable("id") Long id) {
        return locationService.getLocationDto(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public LocationDto updateLocationInTable(@Valid @RequestBody LocationDto locationDto,
                                      @PathVariable("id") Long id) {
        locationDto.setId(id);
        return locationService.updateLocation(locationDto);
    }

    @DeleteMapping(value="/{id}")
    public void deleteLocationFromTable(@Valid @PathVariable("id") Long id) {
        locationService.deleteLocation(id);
    }

}
