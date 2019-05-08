package com.converters;

import com.dto.LocationDto;
import com.entities.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationMapper MAPPER = Mappers.getMapper(LocationMapper.class);

    LocationDto convertToDto(Location location);

    @Mapping(target = "id", ignore = true)
    Location convertToEntity(LocationDto locationDto);
}
