package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.mapper.TravelEntryMapper;
import ua.ithillel.travelapp.repo.TravelEntryRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.MockitoAnnotations.openMocks;

public class TravelEntryServiceDefaultTest extends ServiceTestParent {
    @Mock
    private TravelEntryMapper travelEntryMapper;
    @Mock
    private TravelEntryRepo travelEntryRepo;
    @InjectMocks
    private TravelEntryServiceDefault travelEntryService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void createTravelEntryForUserIdTest_success() {
        TravelEntryDTO mockTravel = mockTravelEntryDTOs.get(0);
        mockTravel.setId(null);
        mockTravel.getLocations().forEach(locationDTO -> locationDTO.setId(null));

        Long testUserId = 1000L;

        TravelEntryDTO createdTravel = travelEntryService.createTravelEntryForUserId(testUserId, mockTravel);

        assertNotNull(createdTravel);
        assertNotNull(createdTravel.getId());
        assertEquals(mockTravel, createdTravel);
    }

    @Test
    public void getTravelEntriesByUserIdTest_success() {
        Long testUserId = 1000L;

        List<TravelEntryDTO> entries = travelEntryService.getTravelEntriesByUserId(testUserId);

        assertNotNull(entries);
    }
}
