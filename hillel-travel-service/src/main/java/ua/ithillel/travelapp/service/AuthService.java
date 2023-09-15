package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.AuthDTO;
import ua.ithillel.travelapp.model.dto.LoginDTO;
import ua.ithillel.travelapp.model.dto.RegisterDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;

public interface AuthService {
    AuthDTO authenticate(LoginDTO loginDTO);
    UserDTO register(RegisterDTO registerDTO);
}
