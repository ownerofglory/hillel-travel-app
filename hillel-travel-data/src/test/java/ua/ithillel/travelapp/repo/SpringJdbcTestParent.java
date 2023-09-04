package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.ithillel.travelapp.jdbc.mapper.UserRowMapper;
import ua.ithillel.travelapp.model.entity.*;
import ua.ithillel.travelapp.util.MockDataTestUtil;

import java.util.List;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {JdbcTestConfig.class})
public class SpringJdbcTestParent {
//    @Autowired
    protected JdbcTemplate jdbcTemplate;
//    @Autowired
    protected UserRowMapper userMapper;

    protected List<User> mockUsers;
    protected List<TravelEntry> mockTravelEntries;
    protected List<Location> mockLocations;
    protected List<Comment> mockComments;
    protected List<Like> mockLikes;

    @BeforeEach
    public void parentSetUp() {
        mockUsers = MockDataTestUtil.getMockItems("mocks/users-db.json", User.class);
        mockTravelEntries = MockDataTestUtil.getMockItems("mocks/travel-entries-db.json", TravelEntry.class);
        mockLocations = MockDataTestUtil.getMockItems("mocks/locations-db.json", Location.class);
        mockComments = MockDataTestUtil.getMockItems("mocks/comments.json", Comment.class);
        mockLikes = MockDataTestUtil.getMockItems("mocks/likes.json", Like.class);
    }
}
