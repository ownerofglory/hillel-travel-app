package ua.ithillel.travelapp.model.dto;

import lombok.Data;

@Data
public class LikeDTO {
    private Long id;
    private Long travelEntryId;

    private UserDTO user;
}
