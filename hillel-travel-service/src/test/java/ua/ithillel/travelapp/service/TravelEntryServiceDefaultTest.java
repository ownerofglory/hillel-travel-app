package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.mapper.TravelEntryMapper;
import ua.ithillel.travelapp.repo.TravelEntryRepo;

import static org.mockito.MockitoAnnotations.openMocks;

public class TravelEntryServiceDefaultTest {
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

    }

    @Test
    public void getTravelEntriesByUserIdTest_success() {

    }
}
