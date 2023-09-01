package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.mapper.LocationMapper;
import ua.ithillel.travelapp.repo.LocationRepo;


import static org.mockito.MockitoAnnotations.openMocks;

public class LocationServiceDefaultTest {
    @Mock
    private LocationMapper locationMapper;
    @Mock
    private LocationRepo locationRepo;
    @InjectMocks
    private LocationServiceDefault locationService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void getLocationForBoundingBoxTest_success() {

    }

    @Test
    public void getLocationByIdTest_success() {

    }
}
