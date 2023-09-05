package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class UserServiceDefault implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public UserDTO getUserById(Long id) throws EntityNotFoundException {
        User user = userRepo.find(id);

        if (user == null) {
            throw new EntityNotFoundException("user with id: " + id + " is not found");
        }

        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User saveUser = userRepo.save(user);

        if (saveUser.getTravelEntries() == null) {
            saveUser.setTravelEntries(new ArrayList<>());
        }

        return userMapper.userToUserDTO(saveUser);
    }
}
