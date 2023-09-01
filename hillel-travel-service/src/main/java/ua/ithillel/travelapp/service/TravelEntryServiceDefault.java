package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.mapper.TravelEntryMapper;
import ua.ithillel.travelapp.repo.TravelEntryRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelEntryServiceDefault implements TravelEntryService {
    private final TravelEntryRepo travelEntryRepo;
    private final TravelEntryMapper travelEntryMapper;

    @Override
    public TravelEntryDTO createTravelEntryForUserId(Long userId, TravelEntryDTO entryDTO) {
        return null;
    }

    @Override
    public List<TravelEntryDTO> getTravelEntriesByUserId(Long userId) {
        return null;
    }
}
