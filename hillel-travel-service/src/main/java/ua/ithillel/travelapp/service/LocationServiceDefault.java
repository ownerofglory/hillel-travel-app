package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.model.dto.BoundingBoxDTO;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.entity.Location;
import ua.ithillel.travelapp.model.mapper.LocationMapper;
import ua.ithillel.travelapp.repo.LocationRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceDefault implements LocationService {
    private static final int LOCATION_LIMIT = 100;

    private final LocationRepo locationRepo;
    private final LocationMapper locationMapper;

    @Override
    public List<LocationDTO> getLocationForBoundingBox(BoundingBoxDTO bbox) {
        List<Location> locations = locationRepo.findLocations(bbox.getNorthEast().getLatitude(),
                bbox.getNorthEast().getLongitude(),
                bbox.getSouthWest().getLatitude(),
                bbox.getSouthWest().getLongitude(),
                LOCATION_LIMIT);

        return locations.stream()
                .map(locationMapper::locationToLocationDTO).toList();
    }

    @Override
    public LocationDTO getLocationById(Long locationId) {
        Location location = locationRepo.find(locationId);
        return locationMapper.locationToLocationDTO(location);
    }
}
