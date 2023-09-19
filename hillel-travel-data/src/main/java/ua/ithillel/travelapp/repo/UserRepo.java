package ua.ithillel.travelapp.repo;

import ua.ithillel.travelapp.model.entity.User;

public interface UserRepo {
    User save(User user);
    User find(Long id);
    User findByUsername(String username);
}
