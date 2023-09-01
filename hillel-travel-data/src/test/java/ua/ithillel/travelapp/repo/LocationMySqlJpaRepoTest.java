package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.entity.Location;

import java.util.List;

public class LocationMySqlJpaRepoTest extends SpringRepoTestParent {
    private LocationRepo locationRepo;
    @BeforeEach
    public void setUp() {
        locationRepo = new LocationMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void findLocationsTest_success() {

    }
}
