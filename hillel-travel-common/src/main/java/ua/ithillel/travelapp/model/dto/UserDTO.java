package ua.ithillel.travelapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"id", "travelEntries", "password"})
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;

    private List<TravelEntryDTO> travelEntries;
}
