package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.model.dto.CommentDTO;
import ua.ithillel.travelapp.model.mapper.CommentMapper;
import ua.ithillel.travelapp.model.mapper.TravelEntryMapper;
import ua.ithillel.travelapp.model.mapper.UserMapper;
import ua.ithillel.travelapp.repo.CommentRepo;
import ua.ithillel.travelapp.repo.TravelEntryRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceDefault implements CommentService {
    private final CommentRepo commentRepo;
    private final CommentMapper commentMapper;

    private final TravelEntryRepo travelEntryRepo;
    private final TravelEntryMapper travelEntryMapper;

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public CommentDTO addComment(CommentDTO comment, Long travelEntryId, Long commenterId) {
        return null;
    }

    @Override
    public CommentDTO editComment(Long commentId, CommentDTO comment) {
        return null;
    }

    @Override
    public CommentDTO deleteComment(Long commentId) {
        return null;
    }

    @Override
    public List<CommentDTO> getCommentsByTravelEntryId(Long travelEntryId) {
        return null;
    }
}
