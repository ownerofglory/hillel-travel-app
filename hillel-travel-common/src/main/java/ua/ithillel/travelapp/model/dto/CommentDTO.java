package ua.ithillel.travelapp.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String commentText;

    private UserDTO user;
}
