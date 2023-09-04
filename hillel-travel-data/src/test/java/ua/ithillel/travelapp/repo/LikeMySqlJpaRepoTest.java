package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.entity.Like;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LikeMySqlJpaRepoTest extends SpringRepoTestParent {
    private LikeRepo likeRepo;

    @BeforeEach
    public void setUp() {
        likeRepo = new LikeMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void findByTravelEntryIdTest_success() {
        TravelEntry travelEntry = mockTravelEntries.get(0);
        List<Like> byTravelEntryId = likeRepo.findByTravelEntryId(travelEntry.getId());

        assertNotNull(byTravelEntryId);
    }

    @Test
    public void  saveTest_success() {
        Like like = mockLikes.get(0);
        User user = mockUsers.get(0);
        TravelEntry travelEntry = mockTravelEntries.get(0);
        Like newLike = new Like(null, user, travelEntry);

        Like savedLike = likeRepo.save(newLike);

        assertNotNull(savedLike);
        assertNotNull(savedLike.getId());
    }

    @Test
    public void removeTest_success() {
        Like like = mockLikes.get(1);
        User user = mockUsers.get(1);
        TravelEntry travelEntry = mockTravelEntries.get(1);
        Like newLike = new Like(null, user, travelEntry);

        likeRepo.remove(like);
    }

}
