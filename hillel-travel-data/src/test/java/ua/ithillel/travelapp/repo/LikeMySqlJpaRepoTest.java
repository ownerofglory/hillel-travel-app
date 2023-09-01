package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.entity.Like;

import java.util.List;

public class LikeMySqlJpaRepoTest extends SpringRepoTestParent {
    private LikeRepo likeRepo;

    @BeforeEach
    public void setUp() {
        likeRepo = new LikeMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void findByTravelEntryIdTest_success() {

    }

    @Test
    public void  saveTest_success() {

    }

    @Test
    public void removeTest_success() {

    }

}
