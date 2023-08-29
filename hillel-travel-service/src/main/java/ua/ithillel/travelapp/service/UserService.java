package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.UserDTO;


public interface UserService {
    UserDTO getUserById(Long id);
    public UserDTO addUser(UserDTO user);
}
