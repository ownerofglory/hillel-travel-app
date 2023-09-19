package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.exception.InconsistencyException;
import ua.ithillel.travelapp.model.dto.AuthDTO;
import ua.ithillel.travelapp.model.dto.LoginDTO;
import ua.ithillel.travelapp.model.dto.RegisterDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;

public interface AuthService {
    AuthDTO authenticate(LoginDTO loginDTO) throws EntityNotFoundException;
    UserDTO register(RegisterDTO registerDTO) throws InconsistencyException;
}
