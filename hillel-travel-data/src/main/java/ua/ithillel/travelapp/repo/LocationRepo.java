package ua.ithillel.travelapp.repo;

import ua.ithillel.travelapp.model.entity.Location;

import java.util.List;

public interface LocationRepo {
    // bounding box : NE - SW
    List<Location> findLocations(double neLat, double neLong, double swLat, double swLong, int limit);
    Location find(Long id);
}
