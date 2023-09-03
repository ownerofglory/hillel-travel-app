package ua.ithillel.travelapp.model.mapper;

import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.entity.Location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocationMapperTest extends MapperTestParent {
    @Test
    public void locationToLocationDTOTest_success() {
        Location location = mockLocations.get(0);

        LocationDTO locationDTO = locationMapper.locationToLocationDTO(location);

        assertNotNull(locationDTO);
        assertEquals(locationDTO.getLocationName(), location.getLocationName());
        assertEquals(locationDTO.getLatitude(), location.getLatitude());
        assertEquals(locationDTO.getLongitude(), location.getLongitude());
    }

    @Test
    public void locationDTOToLocationTest_success() {
        LocationDTO locationDTO = mockLocationDTOs.get(0);

        Location location = locationMapper.locationDTOToLocation(locationDTO);
        assertNotNull(location);
        assertEquals(locationDTO.getLocationName(), location.getLocationName());
        assertEquals(locationDTO.getLatitude(), location.getLatitude());
        assertEquals(locationDTO.getLongitude(), location.getLongitude());
    }
}
