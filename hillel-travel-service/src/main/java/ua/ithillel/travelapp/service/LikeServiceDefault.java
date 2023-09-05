package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.LikeDTO;
import ua.ithillel.travelapp.model.entity.Like;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.model.mapper.LikeMapper;
import ua.ithillel.travelapp.model.mapper.TravelEntryMapper;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.LikeRepo;
import ua.ithillel.travelapp.repo.TravelEntryRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LikeServiceDefault implements LikeService {
    private final LikeRepo likeRepo;
    private final LikeMapper likeMapper;

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    private final TravelEntryRepo travelEntryRepo;
    private final TravelEntryMapper travelEntryMapper;

    @Override
    public LikeDTO like(Long travelEntryId, Long ownId) throws EntityNotFoundException {
        TravelEntry travelEntry = travelEntryRepo.find(travelEntryId);
        if (travelEntry == null) {
            throw new EntityNotFoundException(String.format("TravelEntry with id %d not found", travelEntryId));
        }

        User user = userRepo.find(ownId);
        if (user == null) {
            throw new EntityNotFoundException(String.format("User with id %d not found", ownId));
        }

        Like likeEntity = new Like();
        likeEntity.setTravelEntry(travelEntry);
        likeEntity.setUser(user);

        Like savedLike = likeRepo.save(likeEntity);

        return likeMapper.likeToLikeDTO(savedLike);
    }

    @Override
    public LikeDTO dislike(LikeDTO likeDTO) throws EntityNotFoundException {
        Like existingLike = likeRepo.find(likeDTO.getId());
        if (existingLike == null) {
            throw new EntityNotFoundException(String.format("Like with id %d not found", likeDTO.getId()));
        }

        Long travelEntryId = likeDTO.getTravelEntryId();
        TravelEntry travelEntry = travelEntryRepo.find(travelEntryId);
        if (travelEntry == null || !Objects.equals(existingLike.getTravelEntry().getId(), travelEntryId)) {
            throw new EntityNotFoundException(String.format("TravelEntry with id %d not found", travelEntryId));
        }

        Long userId = likeDTO.getUser().getId();
        User user = userRepo.find(userId);
        if (user == null || !Objects.equals(existingLike.getUser().getId(), userId)) {
            throw new EntityNotFoundException(String.format("User with id %d not found", userId));
        }

        Like removed = likeRepo.remove(existingLike);

        return likeMapper.likeToLikeDTO(removed);
    }

    @Override
    public List<LikeDTO> getLikesByTravelEntryId(Long travelEntryId) {
        List<Like> byTravelEntryId = likeRepo.findByTravelEntryId(travelEntryId);

        return byTravelEntryId.stream()
                .map(likeMapper::likeToLikeDTO).toList();
    }
}
