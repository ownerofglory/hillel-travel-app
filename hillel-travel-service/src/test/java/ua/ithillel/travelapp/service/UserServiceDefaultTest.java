package ua.ithillel.travelapp.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.UserRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.MockitoAnnotations.openMocks;

public class UserServiceDefaultTest extends ServiceTestParent {
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRepo userRepo;
    @InjectMocks
    private UserServiceDefault userService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void getUserByIdTest_success() {
        Long testId = 1000L;
        UserDTO userById = userService.getUserById(testId);

        assertNotNull(userById);
        assertEquals(userById.getId(), testId);
    }

    @Test
    public void addUserTest_success() {
        UserDTO mockUser = mockUserDTOs.get(0);
        mockUser.setId(null);

        UserDTO addedUser = userService.addUser(mockUser);

        assertNotNull(addedUser);
        assertNotNull(addedUser.getId());
        assertEquals(addedUser, mockUser);
    }

}
