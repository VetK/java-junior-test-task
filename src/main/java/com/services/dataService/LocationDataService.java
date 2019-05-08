package com.services.dataService;

import com.entities.Location;
import com.exceptions.LocationAlreadyExist;
import com.exceptions.LocationNotExist;
import com.repositories.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class LocationDataService {

    private LocationRepository locationRepository;

    public LocationDataService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @Transactional
    public Location saveLocation(Location location){
        Location newLocation = locationRepository.findByName(location.getName());
        if(newLocation != null){
            String message = String.format("Location with name %s already exist", location.getName());
            throw new LocationAlreadyExist(message);
        }
        else {
            return locationRepository.save(location);
        }

    }

    public Location getLocationFromDb(Long id){
        Optional<Location> optionalLocation = locationRepository.findById(id);

        if(optionalLocation.isPresent()){
            return optionalLocation.get();
        }
        else{
            String message = String.format("Location with id %d already exist", id);
            throw new LocationNotExist(message);
        }

    }

    @Transactional
    public Location updateLocation(Location Location){
        Optional<Location> optionalLocation = locationRepository.findById(Location.getId());
        if(optionalLocation.isPresent()){
            Location newLocation = optionalLocation.get();
            return locationRepository.saveAndFlush(newLocation);
        }
        else{
            String message = String.format("No Content");
            throw new LocationNotExist(message);
        }
    }

    @Transactional
    public void deleteLocation(Long id){
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if(optionalLocation.isPresent()){
            //Location newLocation = optionalLocation.get();
            locationRepository.deleteById(id);
        }
        else{
            String message = String.format("No Content");
            throw new LocationNotExist(message);
        }
    }


}
