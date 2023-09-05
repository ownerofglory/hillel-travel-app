package ua.ithillel.travelapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private String commentText;
    private Long travelEntryId;
    private Long userId;

    private UserDTO user;
}
