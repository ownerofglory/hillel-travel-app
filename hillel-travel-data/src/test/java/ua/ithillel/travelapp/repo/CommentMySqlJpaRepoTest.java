package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommentMySqlJpaRepoTest extends SpringRepoTestParent {
    private CommentRepo commentRepo;

    @BeforeEach
    public void setUp() {
        commentRepo = new CommentMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void findByTravelEntryIdTest_success() {

    }

    @Test
    public void saveTest_success() {

    }

    @Test
    public void removeTest_success() {

    }
}
