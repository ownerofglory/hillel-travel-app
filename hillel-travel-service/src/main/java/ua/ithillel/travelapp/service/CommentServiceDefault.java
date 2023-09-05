package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.exception.InconsistencyException;
import ua.ithillel.travelapp.model.dto.CommentDTO;
import ua.ithillel.travelapp.model.entity.Comment;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.model.mapper.CommentMapper;
import ua.ithillel.travelapp.repo.CommentRepo;
import ua.ithillel.travelapp.repo.TravelEntryRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentServiceDefault implements CommentService {
    private final CommentRepo commentRepo;
    private final CommentMapper commentMapper;
    private final TravelEntryRepo travelEntryRepo;
    private final UserRepo userRepo;

    @Override
    public CommentDTO addComment(CommentDTO comment, Long travelEntryId, Long commenterId) throws EntityNotFoundException {
        TravelEntry travelEntry = travelEntryRepo.find(travelEntryId);
        if (travelEntry == null) {
            throw new EntityNotFoundException(String.format("TravelEntry with id %d not found", travelEntryId));
        }

        User user = userRepo.find(commenterId);
        if (user == null) {
            throw new EntityNotFoundException(String.format("User with id %d not found", commenterId));
        }

        Comment commentEntity = commentMapper.commentDTOToComment(comment);
        commentEntity.setUser(user);
        commentEntity.setTravelEntry(travelEntry);

        Comment saved = commentRepo.save(commentEntity);
        return commentMapper.commentToCommentDTO(saved);
    }

    @Override
    public CommentDTO editComment(Long commentId, CommentDTO comment) throws EntityNotFoundException, InconsistencyException {
        if (!Objects.equals(comment.getId(), commentId)) {
            throw new InconsistencyException("Comment id you've provied does not match with comment's id");
        }

        Comment existingComment = commentRepo.find(commentId);
        if (existingComment == null) {
            throw new EntityNotFoundException(String.format("Comment with id %d not found", commentId));
        }

        existingComment.setCommentText(comment.getCommentText());

        Comment updatedComment = commentRepo.save(existingComment);

        return commentMapper.commentToCommentDTO(updatedComment);
    }

    @Override
    public CommentDTO deleteComment(Long commentId) throws EntityNotFoundException {
        Comment existingComment = commentRepo.find(commentId);
        if (existingComment == null) {
            throw new EntityNotFoundException(String.format("Comment with id %d not found", commentId));
        }

        Comment removed = commentRepo.remove(existingComment);
        return commentMapper.commentToCommentDTO(removed);
    }

    @Override
    public List<CommentDTO> getCommentsByTravelEntryId(Long travelEntryId) {
        List<Comment> byTravelEntryId = commentRepo.findByTravelEntryId(travelEntryId);
        if (byTravelEntryId == null) {
            return new ArrayList<>();
        }

        return byTravelEntryId.stream()
                .map(commentMapper::commentToCommentDTO).toList();
    }
}
