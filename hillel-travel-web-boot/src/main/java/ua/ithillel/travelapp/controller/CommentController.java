package ua.ithillel.travelapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.exception.InconsistencyException;
import ua.ithillel.travelapp.model.dto.CommentDTO;
import ua.ithillel.travelapp.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getByTravelEntryId(
            @RequestParam(value = "travelEntry", required = true) Long travelEntryId) {
        List<CommentDTO> commentsByTravelEntryId = commentService.getCommentsByTravelEntryId(travelEntryId);
        return ResponseEntity.ok(commentsByTravelEntryId);
    }

    @PostMapping
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO) throws EntityNotFoundException {
        CommentDTO addedComment = commentService.addComment(commentDTO, commentDTO.getUserId(), commentDTO.getTravelEntryId());
        return ResponseEntity.ok(addedComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> editComment(@PathVariable("id") Long commentId,
                                                  @RequestBody CommentDTO commentDTO) throws EntityNotFoundException, InconsistencyException {
        CommentDTO updatedComment = commentService.editComment(commentId, commentDTO);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDTO> editComment(@PathVariable("id") Long commentId) throws EntityNotFoundException {
        CommentDTO deletedComment = commentService.deleteComment(commentId);
        return ResponseEntity.ok(deletedComment);
    }
}
