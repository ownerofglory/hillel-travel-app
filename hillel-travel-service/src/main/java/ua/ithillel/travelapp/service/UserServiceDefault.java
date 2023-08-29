package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.repo.UserRepo;

@RequiredArgsConstructor
@Service
public class UserServiceDefault implements UserService {
    private final UserRepo userRepo;

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public UserDTO addUser(UserDTO user) {
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        User save = userRepo.save(user1);

        return user;
    }
}
