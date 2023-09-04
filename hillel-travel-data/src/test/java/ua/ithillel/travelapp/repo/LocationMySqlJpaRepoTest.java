package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.dto.BoundingBoxDTO;
import ua.ithillel.travelapp.model.dto.CoordinateDTO;
import ua.ithillel.travelapp.model.entity.Location;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationMySqlJpaRepoTest extends SpringRepoTestParent {
    private LocationRepo locationRepo;
    @BeforeEach
    public void setUp() {
        locationRepo = new LocationMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void findLocationsTest_success() {
        CoordinateDTO ne = new CoordinateDTO(15, 50);
        CoordinateDTO sw = new CoordinateDTO(5, 35);
        BoundingBoxDTO boundingBoxDTO = new BoundingBoxDTO(ne, sw);
        int limit = 100;

        List<Location> locations = locationRepo.findLocations(50, 15, 35, 5, limit);

        assertNotNull(locations);
        assertTrue(locations.size() <= limit);
    }
}
