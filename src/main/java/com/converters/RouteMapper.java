package com.converters;

import com.dto.RouteDto;
import com.entities.Route;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface RouteMapper {
    RouteMapper MAPPER = Mappers.getMapper(RouteMapper.class);

    RouteDto convertToDto(Route route);

    Route convertToEntity(RouteDto routeDto);
}
