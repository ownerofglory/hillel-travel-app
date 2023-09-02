package ua.ithillel.travelapp.model.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.ithillel.travelapp.config.MapperTestConfig;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.entity.Location;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.util.MockDataTestUtil;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MapperTestConfig.class})
public class MapperTestParent {
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected TravelEntryMapper travelEntryMapper;
    @Autowired
    protected LocationMapper locationMapper;
    @Autowired
    protected LikeMapper likeMapper;
    @Autowired
    protected CommentMapper commentMapper;

    protected List<UserDTO> mockUserDTOs;
    protected List<TravelEntryDTO> mockTravelEntryDTOs;
    protected List<LocationDTO> mockLocationDTOs;
    protected List<User> mockUsers;
    protected List<TravelEntry> mockTravelEntries;
    protected List<Location> mockLocations;

    @BeforeEach
    public void parentSetUp() {
        mockUserDTOs = MockDataTestUtil.getMockItems("mocks/users.json", UserDTO.class);
        mockTravelEntryDTOs = MockDataTestUtil.getMockItems("mocks/travel-entries.json", TravelEntryDTO.class);
        mockLocationDTOs = MockDataTestUtil.getMockItems("mocks/locations.json", LocationDTO.class);

        mockUsers = MockDataTestUtil.getMockItems("mocks/users-db.json", User.class);
        mockTravelEntries = MockDataTestUtil.getMockItems("mocks/travel-entries-db.json", TravelEntry.class);
        mockLocations = MockDataTestUtil.getMockItems("mocks/locations-db.json", Location.class);
    }
}
