package ua.ithillel.travelapp.repo;

import ua.ithillel.travelapp.model.entity.Comment;

import java.util.List;

public interface CommentRepo {
    List<Comment> findByTravelEntryId(Long id);
    Comment save(Comment comment);
    Comment remove(Comment comment);
    Comment find(Long id);
}
