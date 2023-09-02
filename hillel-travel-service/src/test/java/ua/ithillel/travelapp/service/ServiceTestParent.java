package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.entity.Location;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.util.ServiceTestUtil;

import java.util.List;

public class ServiceTestParent {
    protected List<UserDTO> mockUserDTOs;
    protected List<TravelEntryDTO> mockTravelEntryDTOs;
    protected List<LocationDTO> mockLocationDTOs;
    protected List<User> mockUsers;
    protected List<TravelEntry> mockTravelEntries;
    protected List<Location> mockLocations;

    @BeforeEach
    public void parentSetUp() {
        mockUserDTOs = ServiceTestUtil.getMockItems("mocks/users.json", UserDTO.class);
        mockTravelEntryDTOs = ServiceTestUtil.getMockItems("mocks/travel-entries.json", TravelEntryDTO.class);
        mockLocationDTOs = ServiceTestUtil.getMockItems("mocks/locations.json", LocationDTO.class);

        mockUsers = ServiceTestUtil.getMockItems("mocks/users-db.json", User.class);
        mockTravelEntries = ServiceTestUtil.getMockItems("mocks/travel-entries-db.json", TravelEntry.class);
        mockLocations = ServiceTestUtil.getMockItems("mocks/locations-db.json", Location.class);
    }
}
