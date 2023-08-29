package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.TravelEntryDTO;

import java.util.List;

public interface TravelEntryService {
    TravelEntryDTO createTravelEntryForUserId(Long userId, TravelEntryDTO entryDTO);
    List<TravelEntryDTO> getTravelEntriesByUserId(Long userId);
}
