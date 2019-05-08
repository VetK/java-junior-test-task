package com.dto;

import com.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {
    Long id;
    String name;
    Location head; //Location where the route begins
    List<Location> locations;
}
