package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.dto.LikeDTO;
import ua.ithillel.travelapp.model.mapper.LikeMapper;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.LikeRepo;
import ua.ithillel.travelapp.repo.TravelEntryRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class LikeServiceDefaultTest extends ServiceTestParent {
    @Mock
    private LikeMapper likeMapper;
    @Mock
    private LikeRepo likeRepo;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRepo userRepo;
    @Mock
    private TravelEntryRepo travelEntryRepo;
    @InjectMocks
    private LikeServiceDefault likeService;

    @BeforeEach
    public void setUp() {
        openMocks(this);

        when(likeMapper.likeToLikeDTO(any())).thenReturn(mockLikeDTOs.get(0));
        when(likeMapper.likeDTOToLike(any())).thenReturn(mockLikes.get(0));
        when(userRepo.find(anyLong())).thenReturn(mockUsers.get(0));
        when(travelEntryRepo.find(anyLong())).thenReturn(mockTravelEntries.get(0));
    }

    @Test
    public void toggleLikeTest_success() {
        Long testTravelEntryId = mockTravelEntries.get(0).getId();
        Long testUserId = mockUsers.get(0).getId();

        LikeDTO likeDTO = likeService.toggleLike(testTravelEntryId, testUserId);

        assertNotNull(likeDTO);
        assertEquals(likeDTO.getUser().getId(), testUserId);
    }

    @Test
    public void getLikesByTravelEntryIdTest_success() {
        Long testTravelEntryId = 1000L;

        List<LikeDTO> likesByTravelEntryId = likeService.getLikesByTravelEntryId(testTravelEntryId);

        assertNotNull(likesByTravelEntryId);
    }
}
