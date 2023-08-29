package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.CommentDTO;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;

import java.util.List;

public interface CommentService {
    CommentDTO addComment(CommentDTO comment, Long travelEntryId, Long commenterId);
    CommentDTO editComment(Long commentId, CommentDTO comment);
    CommentDTO deleteComment(Long commentId);
    List<CommentDTO> getCommentsByTravelEntryId(Long travelEntryId);
}
