package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import ua.ithillel.travelapp.model.entity.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserJdbcDaoTest extends SpringJdbcTestParent {
    private UserRepo userRepo;

    @BeforeEach
    public void setUp() {
        userRepo = new UserJdbcDao(jdbcTemplate, userMapper);
    }

//    @Test
    public void saveTest_success() {
        User user = mockUsers.get(0);
        User newUser = new User(null, user.getName(), user.getEmail(), user.getPassword(), new ArrayList<>());

        User savedUser = userRepo.save(newUser);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(newUser, savedUser);
    }

//    @Test
    public void findTest_success() {
        Long testId = 1L;
        User user = userRepo.find(testId);

        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals(user.getId(), testId);
    }
}
