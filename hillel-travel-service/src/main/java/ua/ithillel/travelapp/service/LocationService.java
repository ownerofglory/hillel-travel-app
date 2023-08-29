package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.BoundingBoxDTO;
import ua.ithillel.travelapp.model.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    List<LocationDTO> getLocationForBoundingBox(BoundingBoxDTO bbox);
    LocationDTO getLocationById(Long locationId);
}
