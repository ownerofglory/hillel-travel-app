package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.UserDTO;


public interface UserService {
    UserDTO getUserById(Long id) throws EntityNotFoundException;
    UserDTO addUser(UserDTO user);
}
