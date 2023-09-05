package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.model.mapper.TravelEntryMapper;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.TravelEntryRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelEntryServiceDefault implements TravelEntryService {
    private final TravelEntryRepo travelEntryRepo;
    private final TravelEntryMapper travelEntryMapper;

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public TravelEntryDTO createTravelEntryForUserId(Long userId, TravelEntryDTO entryDTO) throws EntityNotFoundException {
        User user = userRepo.find(userId);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + userId + " is not found");
        }

        TravelEntry travelEntry = travelEntryMapper.travelEntryDTOToTravelEntry(entryDTO);
        travelEntry.setUser(user);

        TravelEntry savedEntry = travelEntryRepo.save(travelEntry);

        return travelEntryMapper.travelEntryToTravelEntryDTO(savedEntry);
    }

    @Override
    public List<TravelEntryDTO> getTravelEntriesByUserId(Long userId) {
        List<TravelEntry> byUserId = travelEntryRepo.findByUserId(userId);

        return byUserId.stream()
                .map(travelEntryMapper::travelEntryToTravelEntryDTO).toList();
    }
}
