package com.services.controllerService;


import com.converters.LocationMapper;
import com.dto.LocationDto;
import com.entities.Location;
import com.services.dataService.LocationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationService {

    @Autowired
    private LocationDataService locationDataService;

    public LocationDto saveLocation(LocationDto locationDto){
        Location newLocation = locationDataService.saveLocation(LocationMapper.MAPPER.convertToEntity(locationDto));
        return LocationMapper.MAPPER.convertToDto(newLocation);
    }

    public LocationDto getLocationDto(Long id){
        return LocationMapper.MAPPER.convertToDto(locationDataService.getLocationFromDb(id));
    }

    @Transactional
    public LocationDto updateLocation(LocationDto locationDto){
        Location newLocation = locationDataService.updateLocation(LocationMapper.MAPPER.convertToEntity(locationDto));
        return LocationMapper.MAPPER.convertToDto(newLocation);
    }

    @Transactional
    public void deleteLocation(Long id){
        locationDataService.deleteLocation(id);
    }

}
