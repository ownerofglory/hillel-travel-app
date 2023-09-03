package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.dto.LikeDTO;
import ua.ithillel.travelapp.model.mapper.LikeMapper;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.LikeRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    @InjectMocks
    private LikeServiceDefault likeService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void toggleLikeTest_success() {
        Long testTravelEntryId = 1000L;
        Long testUserId = 200L;

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
