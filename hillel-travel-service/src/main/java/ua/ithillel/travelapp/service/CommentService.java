package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.exception.InconsistencyException;
import ua.ithillel.travelapp.model.dto.CommentDTO;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;

import java.util.List;

public interface CommentService {
    CommentDTO addComment(CommentDTO comment, Long travelEntryId, Long commenterId) throws EntityNotFoundException;
    CommentDTO editComment(Long commentId, CommentDTO comment) throws EntityNotFoundException, InconsistencyException;
    CommentDTO deleteComment(Long commentId) throws EntityNotFoundException;
    List<CommentDTO> getCommentsByTravelEntryId(Long travelEntryId);
}
