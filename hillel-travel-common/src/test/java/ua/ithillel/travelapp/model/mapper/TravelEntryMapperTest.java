package ua.ithillel.travelapp.model.mapper;


import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.entity.TravelEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TravelEntryMapperTest extends MapperTestParent {
    @Test
    public void travelEntryToTravelEntryDTOTest_success() {
        TravelEntry travelEntry = mockTravelEntries.get(0);

        TravelEntryDTO travelEntryDTO = travelEntryMapper.travelEntryToTravelEntryDTO(travelEntry);

        assertNotNull(travelEntryDTO);
        assertEquals(travelEntryDTO.getTitle(), travelEntry.getTitle());
        assertEquals(travelEntryDTO.getDescription(), travelEntry.getDescription());
        assertEquals(travelEntryDTO.getCommentCount(), travelEntry.getComments().size());
        assertEquals(travelEntryDTO.getLikeCount(), travelEntry.getLikes().size());
    }

    @Test
    public void travelEntryDTOToTravelEntryTest_success() {
        TravelEntryDTO travelEntryDTO = mockTravelEntryDTOs.get(0);

        TravelEntry travelEntry = travelEntryMapper.travelEntryDTOToTravelEntry(travelEntryDTO);

        assertNotNull(travelEntry);
        assertEquals(travelEntryDTO.getTitle(), travelEntry.getTitle());
        assertEquals(travelEntryDTO.getDescription(), travelEntry.getDescription());
    }
}
