package ua.ithillel.travelapp.model.dto;

import lombok.Data;

@Data
public class BoundingBoxDTO {
    private CoordinateDTO northEast;
    private CoordinateDTO southWest;
}
