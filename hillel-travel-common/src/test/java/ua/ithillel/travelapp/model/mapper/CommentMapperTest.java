package ua.ithillel.travelapp.model.mapper;

import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.dto.CommentDTO;
import ua.ithillel.travelapp.model.entity.Comment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommentMapperTest extends MapperTestParent {
    @Test
    public void commentToCommentDTOTest_success() {
        Comment comment = mockComments.get(0);

        CommentDTO commentDTO = commentMapper.commentToCommentDTO(comment);

        assertNotNull(commentDTO);
        assertNotNull(commentDTO.getId());
        assertEquals(commentDTO.getId(), comment.getId());
        assertEquals(commentDTO.getCommentText(), comment.getCommentText());
    }
    @Test
    public void commentDTOToCommentTest_success() {
        CommentDTO commentDTO = mockCommentDTOs.get(0);

        Comment comment = commentMapper.commentDTOToComment(commentDTO);

        assertNotNull(commentDTO);
        assertEquals(commentDTO.getCommentText(), comment.getCommentText());
    }
}
