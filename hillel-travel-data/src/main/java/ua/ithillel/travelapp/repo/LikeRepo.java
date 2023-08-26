package ua.ithillel.travelapp.repo;

import java.util.List;
import ua.ithillel.travelapp.model.entity.Like;

public interface LikeRepo {
    List<Like> findByTravelEntryId(Long travelEntryId);
    Like save(Like like);
    Like remove(Like like);
}
