package com.services.controllerService;


import com.converters.RouteMapper;
import com.dto.RouteDto;
import com.entities.Location;
import com.entities.Route;
import com.services.dataService.RouteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class RouteService {

    private static double total_distance = 0.0;

    @Autowired
    private RouteDataService routeDataService;

    public RouteDto saveRoutes(RouteDto routeDto){
        Route newRoute = routeDataService.saveRouters(RouteMapper.MAPPER.convertToEntity(routeDto));
        return RouteMapper.MAPPER.convertToDto(newRoute);
    }

    public RouteDto getRouteDto(Long id){
        return RouteMapper.MAPPER.convertToDto(routeDataService.getRouteFromDb(id));
    }

    public RouteDto updateRoute(RouteDto routeDto){
        Route newRoute = routeDataService.updateRoute(RouteMapper.MAPPER.convertToEntity(routeDto));
        return RouteMapper.MAPPER.convertToDto(newRoute);
    }

    public void deleteRoute(Long id){
        routeDataService.deleteRoute(id);
    }


    //not work, more to do
    public void getRoutesPlan(Long id){
        double total_distance=0;
        Route route = routeDataService.getRouteFromDb(id);
        List<Location> locations = new ArrayList<>();
        List<Location> locationsList = route.getLocations();
        locations = locationsList;
        for (int i=0; i<=locations.size(); i++){
            double x = locations.get(i).getX();
            double y = locations.get(i).getY();
            double distance = Math.sqrt(Math.pow(x,2)-Math.pow(y,2));
            total_distance +=distance;
        }
    }

}
