package ua.ithillel.travelapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    private Long id;
    private Double latitude;
    private Double longitude;
    private String locationName;
    private String imageUrl;

    private TravelEntryDTO travelEntry;
}
