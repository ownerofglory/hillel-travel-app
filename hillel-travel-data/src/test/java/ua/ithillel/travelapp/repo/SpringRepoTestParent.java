package ua.ithillel.travelapp.repo;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.ithillel.travelapp.config.JpaTestConfig;
import ua.ithillel.travelapp.model.entity.*;
import ua.ithillel.travelapp.util.MockDataTestUtil;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {JpaTestConfig.class})
public class SpringRepoTestParent {
    @Autowired
    protected SessionFactory sessionFactory;

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
        mockComments = MockDataTestUtil.getMockItems("mocks/comments-db.json", Comment.class);
        mockLikes = MockDataTestUtil.getMockItems("mocks/likes-db.json", Like.class);

    }
}
