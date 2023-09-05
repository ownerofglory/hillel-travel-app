package ua.ithillel.travelapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.exception.InconsistencyException;
import ua.ithillel.travelapp.model.dto.CommentDTO;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.mapper.CommentMapper;
import ua.ithillel.travelapp.repo.CommentRepo;
import ua.ithillel.travelapp.repo.TravelEntryRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class CommentServiceDefaultTest extends ServiceTestParent {
    @Mock
    private CommentMapper commentMapper;
    @Mock
    private CommentRepo commentRepo;
    @Mock
    private UserRepo userRepo;
    @Mock
    private TravelEntryRepo travelEntryRepo;
    @InjectMocks
    private CommentServiceDefault commentService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        when(commentRepo.save(any())).thenReturn(mockComments.get(0));
        when(commentRepo.find(anyLong())).thenReturn(mockComments.get(0));
        when(commentRepo.remove(any())).thenReturn(mockComments.get(1));
        when(commentRepo.findByTravelEntryId(anyLong())).thenReturn(mockComments);
        when(commentMapper.commentDTOToComment(any())).thenReturn(mockComments.get(0));
        when(commentMapper.commentToCommentDTO(any())).thenReturn(mockCommentDTOs.get(0));
        when(userRepo.find(anyLong())).thenReturn(mockUsers.get(0));
        when(travelEntryRepo.find(anyLong())).thenReturn(mockTravelEntries.get(0));
    }

    @Test
    public void addCommentTest_success() throws EntityNotFoundException {
        CommentDTO commentDTO = mockCommentDTOs.get(0);
        TravelEntryDTO travelEntry = mockTravelEntryDTOs.get(0);
        UserDTO user = mockUserDTOs.get(0);
        CommentDTO newComment = new CommentDTO(null, commentDTO.getCommentText(), user);

        CommentDTO savedComment = commentService.addComment(newComment, travelEntry.getId(), user.getId());

        assertNotNull(savedComment);
        assertNotNull(savedComment.getId());
    }

    @Test
    public void  editCommentTest_success() throws InconsistencyException, EntityNotFoundException {
        CommentDTO commentDTO = mockCommentDTOs.get(0);

        CommentDTO editedComment = commentService.editComment(commentDTO.getId(), commentDTO);

        assertNotNull(editedComment);
        assertEquals(editedComment, commentDTO);
    }

    @Test
    public void  deleteCommentTest_success() throws EntityNotFoundException {
        Long testCommentId = mockCommentDTOs.get(0).getId();
        CommentDTO commentDTO = commentService.deleteComment(testCommentId);

        assertNotNull(commentDTO);
        assertEquals(testCommentId, commentDTO.getId());
    }

    @Test
    public void  getCommentsByTravelEntryIdTest_success() {
        Long travelEntryId = mockTravelEntryDTOs.get(0).getId();
        List<CommentDTO> commentsByTravelEntryId = commentService.getCommentsByTravelEntryId(travelEntryId);

        assertNotNull(commentsByTravelEntryId);
    }
}
