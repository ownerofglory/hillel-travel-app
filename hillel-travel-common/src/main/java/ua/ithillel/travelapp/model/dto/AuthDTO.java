package ua.ithillel.travelapp.model.dto;

import lombok.Data;

@Data
public class AuthDTO {
    private UserDTO user;
    private String token;
}
