package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.model.dto.LikeDTO;
import ua.ithillel.travelapp.model.mapper.LikeMapper;
import ua.ithillel.travelapp.model.mapper.TravelEntryMapper;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.LikeRepo;
import ua.ithillel.travelapp.repo.TravelEntryRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.List;

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
    public LikeDTO toggleLike(Long travelEntryId, Long ownId) {
        return null;
    }

    @Override
    public List<LikeDTO> getLikesByTravelEntryId(Long travelEntryId) {
        return null;
    }
}
