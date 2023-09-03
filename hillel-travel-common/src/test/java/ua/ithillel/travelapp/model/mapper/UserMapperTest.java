package ua.ithillel.travelapp.model.mapper;


import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest extends MapperTestParent {
    @Test
    public  void userToUserDTOTest_success() {
        User user = mockUsers.get(0);

        UserDTO userDTO = userMapper.userToUserDTO(user);

        assertNotNull(userDTO);
        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getEmail(), userDTO.getEmail());
    }

    @Test
    public  void userDTOToUserTest_success() {
        UserDTO userDTO = mockUserDTOs.get(0);

        User user = userMapper.userDTOToUser(userDTO);

        assertNotNull(user);
        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getEmail(), userDTO.getEmail());
    }
}
