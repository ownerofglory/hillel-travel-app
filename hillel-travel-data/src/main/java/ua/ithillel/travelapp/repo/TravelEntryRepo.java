package ua.ithillel.travelapp.repo;

import ua.ithillel.travelapp.model.entity.TravelEntry;

import java.util.List;

public interface TravelEntryRepo {
    TravelEntry find(Long id);
    List<TravelEntry> findByUserId(Long userId);
    TravelEntry save(TravelEntry travelEntry);
    TravelEntry remove(TravelEntry travelEntry);
}
