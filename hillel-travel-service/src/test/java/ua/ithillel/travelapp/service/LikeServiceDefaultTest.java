package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.mapper.LikeMapper;
import ua.ithillel.travelapp.repo.LikeRepo;

import static org.mockito.MockitoAnnotations.openMocks;

public class LikeServiceDefaultTest {
    @Mock
    private LikeMapper likeMapper;
    @Mock
    private LikeRepo likeRepo;
    @InjectMocks
    private LikeServiceDefault likeService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void toggleLikeTest_success() {

    }

    @Test
    public void getLikesByTravelEntryIdTest_success() {

    }
}
