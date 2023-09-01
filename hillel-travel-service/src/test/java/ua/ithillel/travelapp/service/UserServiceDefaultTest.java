package ua.ithillel.travelapp.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.UserRepo;

import static org.mockito.MockitoAnnotations.openMocks;

public class UserServiceDefaultTest {
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

    }

    @Test
    public void addUserTest_success() {

    }

}
