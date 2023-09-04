package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.entity.Location;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TravelEntryMySqlJpaRepoTest extends SpringRepoTestParent {
    private TravelEntryRepo travelEntryRepo;
    @BeforeEach
    public void setUp() {
        travelEntryRepo = new TravelEntryMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void findTest_success() {
        Long testId = 1L;
        TravelEntry travelEntry = travelEntryRepo.find(testId);

        assertNotNull(travelEntry);
        assertNotNull(travelEntry.getId());
        assertEquals(testId, travelEntry.getId());
    }

    @Test
    public void findByUserIdTest_success() {
        Long testUserId = 1L;

        List<TravelEntry> byUserId = travelEntryRepo.findByUserId(testUserId);

        assertNotNull(byUserId);
    }

    @Test
    public void saveTest_success() {
        TravelEntry travelEntry = mockTravelEntries.get(1);
        User testUser = travelEntry.getUser();
        List<Location> testLocations = travelEntry.getLocations().stream().map(location
                        -> new Location(null, location.getLatitude(), location.getLongitude(), location.getLocationName(), null))
                .toList();

        TravelEntry newTravelEntry = new TravelEntry(null,
                travelEntry.getTitle(),
                travelEntry.getDescription(),
                travelEntry.getEntryDate(),
                testUser,
                testLocations,
                new ArrayList<>(),
                new ArrayList<>());

        TravelEntry savedEntry = travelEntryRepo.save(newTravelEntry);

        assertNotNull(savedEntry);
        assertNotNull(savedEntry.getId());
        assertEquals(savedEntry, newTravelEntry);
    }

    @Test
    public void removeTest_success() {
        TravelEntry travelEntry = mockTravelEntries.get(1);
        TravelEntry removedEntry = travelEntryRepo.remove(travelEntry);

        assertNotNull(removedEntry);
        assertNotNull(removedEntry.getId());
        assertEquals(removedEntry, travelEntry);
    }
}
