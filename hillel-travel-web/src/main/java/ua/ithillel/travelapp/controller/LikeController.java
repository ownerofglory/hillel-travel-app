package ua.ithillel.travelapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.LikeDTO;
import ua.ithillel.travelapp.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @GetMapping
    public @ResponseBody
    ResponseEntity<List<LikeDTO>> getByTravelEntryId(@RequestParam("travelEntryId") Long travelEntryId) {
        List<LikeDTO> byTravelEntryId = likeService.getLikesByTravelEntryId(travelEntryId);

        return ResponseEntity.ok(byTravelEntryId);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<LikeDTO> addLike(@RequestBody LikeDTO likeDTO) throws EntityNotFoundException {
        LikeDTO like = likeService.like(likeDTO.getTravelEntryId(), likeDTO.getUser().getId());

        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<LikeDTO> removeLike(@PathVariable("id") Long likeId) throws EntityNotFoundException {
        LikeDTO dislike = likeService.dislike(likeId);

        return ResponseEntity.ok(dislike);
    }
}
