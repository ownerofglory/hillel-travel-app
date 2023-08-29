package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.UserDTO;


public interface UserService {
    UserDTO getUserById(Long id);
    UserDTO addUser(UserDTO user);
}
