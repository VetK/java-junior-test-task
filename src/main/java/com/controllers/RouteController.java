package com.controllers;


import com.dto.RouteDto;
import com.entities.Location;
import com.services.controllerService.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping
    @ResponseBody
    public RouteDto addRouteToTable(@RequestBody RouteDto routeDto,
                                 @RequestParam("locations")List <Location> locations){
        routeDto.setLocations(locations);
        return routeService.saveRoutes(routeDto);
    }

    @GetMapping(value = "/{id}")
    public RouteDto getRoute(@PathVariable("id") Long id) {
        return routeService.getRouteDto(id);
    }

    @PutMapping(value = "/{id}")
    public RouteDto updateRouteInTable(@RequestBody RouteDto routeDto,
                                   @PathVariable("id") Long id) {
        routeDto.setId(id);
        return routeService.updateRoute(routeDto);
    }

    @DeleteMapping(value="/{id}")
    public void deleteRouteFromTable(@Valid @PathVariable("id") Long id) {
        routeService.deleteRoute(id);
    }



    @GetMapping("/{id}/plan")
    public void getRoutesPlan (@Valid @PathVariable("id") Long id){
        routeService.getRoutesPlan(id);
    }
}
