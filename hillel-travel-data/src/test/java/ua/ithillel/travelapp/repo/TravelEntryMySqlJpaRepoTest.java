package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.entity.TravelEntry;

import java.util.List;

public class TravelEntryMySqlJpaRepoTest extends SpringRepoTestParent {
    private TravelEntryRepo travelEntryRepo;
    @BeforeEach
    public void setUp() {
        travelEntryRepo = new TravelEntryMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void findTest_success() {

    }

    @Test
    public void findByUserIdTest_success(Long userId) {

    }

    @Test
    public void saveTest_success() {

    }

    @Test
    public void removeTest_success() {

    }
}
