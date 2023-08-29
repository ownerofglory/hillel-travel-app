package ua.ithillel.travelapp.model.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private Long id;
    private Double latitude;
    private Double longitude;
    private String locationName;

    private TravelEntryDTO travelEntry;
}
