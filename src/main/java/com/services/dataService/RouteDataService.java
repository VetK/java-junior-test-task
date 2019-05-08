package com.services.dataService;


import com.entities.Location;
import com.entities.Route;
import com.exceptions.LocationNotAvailable;
import com.exceptions.RouteNotExist;
import com.repositories.LocationRepository;
import com.repositories.RouteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RouteDataService {

    private RouteRepository routeRepository;

    public RouteDataService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    private LocationRepository locationRepository;

    public RouteDataService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    private boolean ifLocationAvailable(Long id){
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if(optionalLocation.isPresent()){
            Location location = optionalLocation.get();
            if(location.isHead()){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Transactional
    public Route saveRouters(Route route){
        if(ifLocationAvailable(route.getHead().getId())){
            return routeRepository.save(route);
        }
        else{
            String message = String.format("Location with id %d is not Available", route.getHead().getId());
            throw new LocationNotAvailable(message);
        }
    }

    public Route getRouteFromDb(Long id){

        Optional<Route> optionalRoute = routeRepository.findById(id);

        if(optionalRoute.isPresent()){
            return optionalRoute.get();
        }
        else{
            String message = String.format("Router with id %d already exist", id);
            throw new RouteNotExist(message);
        }
    }

    @Transactional
    public Route updateRoute(Route route){
        Optional<Route> optionalRoute = routeRepository.findById(route.getId());
        if(optionalRoute.isPresent()){
            Route newRoute = optionalRoute.get();
            return routeRepository.saveAndFlush(newRoute);
        }
        else{
            String message = String.format("No Content");
            throw new RouteNotExist(message);
        }
    }

    @Transactional
    public void deleteRoute(Long id){
        Optional<Route> optionalRoute = routeRepository.findById(id);
        if(optionalRoute.isPresent()){
            routeRepository.deleteById(id);
        }
        else{
            String message = String.format("No Content");
            throw new RouteNotExist(message);
        }
    }

}
