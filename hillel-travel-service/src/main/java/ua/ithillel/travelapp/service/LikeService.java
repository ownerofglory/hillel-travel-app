package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.LikeDTO;

import java.util.List;

public interface LikeService {
    LikeDTO like(Long travelEntryId, Long ownId) throws EntityNotFoundException;
    LikeDTO dislike(LikeDTO likeDTO) throws EntityNotFoundException;
    List<LikeDTO> getLikesByTravelEntryId(Long travelEntryId);
}
