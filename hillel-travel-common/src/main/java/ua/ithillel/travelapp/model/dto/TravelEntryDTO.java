package ua.ithillel.travelapp.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"id", "locations", "likeCount", "commentCount"})
public class TravelEntryDTO {
    private Long id;
    private String title;
    private String description;
    private Date entryDate;

    private Integer commentCount;
    private Integer likeCount;

    private List<LocationDTO> locations;
}
