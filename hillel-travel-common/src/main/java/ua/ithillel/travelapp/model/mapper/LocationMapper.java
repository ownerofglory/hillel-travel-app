package ua.ithillel.travelapp.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.entity.Location;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class LocationMapper {
    public abstract LocationDTO locationToLocationDTO(Location location);
    public abstract Location locationDTOToLocation(LocationDTO locationDTO);
}
