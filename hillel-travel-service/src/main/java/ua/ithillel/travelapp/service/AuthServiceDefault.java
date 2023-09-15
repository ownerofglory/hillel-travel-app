package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.AuthDTO;
import ua.ithillel.travelapp.model.dto.LoginDTO;
import ua.ithillel.travelapp.model.dto.RegisterDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;

public class AuthServiceDefault implements AuthService {
    @Override
    public AuthDTO authenticate(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) {
        return null;
    }
}
