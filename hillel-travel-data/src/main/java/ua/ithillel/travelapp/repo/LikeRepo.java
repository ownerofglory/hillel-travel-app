package ua.ithillel.travelapp.repo;

import ua.ithillel.travelapp.model.entity.Like;

import java.util.List;

public interface LikeRepo {
    Like find(Long id);
    List<Like> findByTravelEntryId(Long travelEntryId);
    Like save(Like like);
    Like remove(Like like);
}
