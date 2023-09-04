package ua.ithillel.travelapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.entity.Comment;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommentMySqlJpaRepoTest extends SpringRepoTestParent {
    private CommentRepo commentRepo;

    @BeforeEach
    public void setUp() {
        commentRepo = new CommentMySqlJpaRepo(sessionFactory);
    }

    @Test
    public void findByTravelEntryIdTest_success() {
        TravelEntry travelEntry = mockTravelEntries.get(0);

        List<Comment> byTravelEntryId = commentRepo.findByTravelEntryId(travelEntry.getId());

        assertNotNull(byTravelEntryId);
    }

    @Test
    public void saveTest_success() {
        Comment comment = mockComments.get(0);
        TravelEntry travelEntry = mockTravelEntries.get(0);
        User user = mockUsers.get(0);

        Comment newComment = new Comment(null, comment.getCommentText(), travelEntry, user);

        Comment savedComment = commentRepo.save(newComment);

        assertNotNull(savedComment);
        assertNotNull(savedComment.getId());
        assertEquals(newComment, savedComment);
    }

    @Test
    public void removeTest_success() {

    }
}
