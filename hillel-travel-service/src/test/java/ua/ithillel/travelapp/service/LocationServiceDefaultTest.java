package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.dto.BoundingBoxDTO;
import ua.ithillel.travelapp.model.dto.CoordinateDTO;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.mapper.LocationMapper;
import ua.ithillel.travelapp.repo.LocationRepo;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class LocationServiceDefaultTest extends ServiceTestParent {
    @Mock
    private LocationMapper locationMapper;
    @Mock
    private LocationRepo locationRepo;
    @InjectMocks
    private LocationServiceDefault locationService;

    @BeforeEach
    public void setUp() {
        openMocks(this);

        when(locationMapper.locationToLocationDTO(any())).thenReturn(mockLocationDTOs.get(0));
        when(locationMapper.locationDTOToLocation(any())).thenReturn(mockLocations.get(0));
    }

    @Test
    public void getLocationForBoundingBoxTest_success() {
        CoordinateDTO sw = new CoordinateDTO(9, 48);
        CoordinateDTO ne = new CoordinateDTO(9.1, 48.1);
        BoundingBoxDTO boundingBoxDTO = new BoundingBoxDTO(ne, sw);

        List<LocationDTO> locationForBoundingBox = locationService.getLocationForBoundingBox(boundingBoxDTO);

        assertNotNull(locationForBoundingBox);
    }

    @Test
    public void getLocationByIdTest_success() {
        Long testId = 2000L;

        LocationDTO locationById = locationService.getLocationById(testId);

        assertNotNull(locationById);
        assertNotNull(locationById.getId());
        assertEquals(locationById.getId(), testId);
    }
}
