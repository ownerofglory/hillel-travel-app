package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.LikeDTO;

import java.util.List;

public interface LikeService {
    LikeDTO toggleLike(Long travelEntryId, Long ownId);
    List<LikeDTO> getLikesByTravelEntryId(Long travelEntryId);
}
