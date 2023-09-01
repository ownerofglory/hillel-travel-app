package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.model.dto.BoundingBoxDTO;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.mapper.LocationMapper;
import ua.ithillel.travelapp.repo.LocationRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceDefault implements LocationService {
    private final LocationRepo locationRepo;
    private final LocationMapper locationMapper;

    @Override
    public List<LocationDTO> getLocationForBoundingBox(BoundingBoxDTO bbox) {
        return null;
    }

    @Override
    public LocationDTO getLocationById(Long locationId) {
        return null;
    }
}
