package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.model.mapper.CommentMapper;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.CommentRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import static org.mockito.MockitoAnnotations.openMocks;

public class CommentServiceDefaultTest {
    @Mock
    private CommentMapper commentMapper;
    @Mock
    private CommentRepo commentRepo;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRepo userRepo;
    @InjectMocks
    private CommentServiceDefault commentService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void addCommentTest_success() {

    }

    @Test
    public void  editCommentTest_success() {

    }

    @Test
    public void  deleteCommentTest_success() {

    }

    @Test
    public void  getCommentsByTravelEntryIdTest_success() {

    }
}
