package ua.ithillel.travelapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.travelapp.model.dto.AuthDTO;
import ua.ithillel.travelapp.model.dto.LoginDTO;
import ua.ithillel.travelapp.service.AuthService;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<AuthDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(null);
    }
}
