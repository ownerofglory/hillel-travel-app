package ua.ithillel.travelapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoundingBoxDTO {
    private CoordinateDTO northEast;
    private CoordinateDTO southWest;
}
