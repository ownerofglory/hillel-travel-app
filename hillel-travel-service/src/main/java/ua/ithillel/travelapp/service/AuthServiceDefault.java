package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.auth.AppUserDetails;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.exception.InconsistencyException;
import ua.ithillel.travelapp.model.dto.AuthDTO;
import ua.ithillel.travelapp.model.dto.LoginDTO;
import ua.ithillel.travelapp.model.dto.RegisterDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.UserRepo;
import ua.ithillel.travelapp.util.JwtUtil;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthServiceDefault implements AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    @Override
    public AuthDTO authenticate(LoginDTO loginDTO) throws EntityNotFoundException {
        User byUsername = userRepo.findByUsername(loginDTO.getUsername());
        if (byUsername == null) {
            throw new EntityNotFoundException("User with username '"
                    + loginDTO.getUsername() + "' does not exist");
        }

        boolean matches = passwordEncoder.matches(loginDTO.getPassword(), byUsername.getPassword());
        if (matches) {
            if (byUsername.getTravelEntries() == null) {
                byUsername.setTravelEntries(new ArrayList<>());
            }

            AppUserDetails appUserDetails = new AppUserDetails(byUsername);
            String token = jwtUtil.generateToken(appUserDetails);

            AuthDTO authDTO = new AuthDTO();
            authDTO.setUser(userMapper.userToUserDTO(byUsername));
            authDTO.setToken(token);

            return authDTO;
        }
        return null;
    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) throws InconsistencyException {
        User byUsername = userRepo.findByUsername(registerDTO.getEmail());
        if (byUsername != null) {
            throw new InconsistencyException(
                    "User with username '" + registerDTO.getEmail() + "' already exists");
        }

        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setName(registerDTO.getName());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setTravelEntries(new ArrayList<>());

        User savedUser = userRepo.save(user);

        return userMapper.userToUserDTO(savedUser);
    }
}
