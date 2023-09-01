package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserMySqlJpaRepoTest extends SpringRepoTestParent {
    private UserRepo userRepo;
    @BeforeEach
    public void setUp() {
        userRepo = new UserMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void saveTest_success() {

    }

    @Test
    public void findTest_success() {

    }
}
