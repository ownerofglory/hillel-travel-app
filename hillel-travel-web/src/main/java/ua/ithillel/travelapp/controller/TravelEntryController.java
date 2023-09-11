package ua.ithillel.travelapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.service.TravelEntryService;

import java.util.List;

@RestController
@RequestMapping("/travelEntries")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TravelEntryController {
    private final TravelEntryService travelEntryService;

    @GetMapping("/users") // /api/travelEntries/users?userId=2
    public @ResponseBody
    ResponseEntity<List<TravelEntryDTO>> getByUserId(
            @RequestParam(name = "userId", required = true) Long userId) {
        List<TravelEntryDTO> entries = travelEntryService.getTravelEntriesByUserId(userId);

        return ResponseEntity.ok(entries);
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<TravelEntryDTO> add(@RequestBody TravelEntryDTO travelEntryDTO) throws EntityNotFoundException {
        TravelEntryDTO entryDTO = travelEntryService.createTravelEntryForUserId(travelEntryDTO.getUserId(), travelEntryDTO);

        return ResponseEntity.ok(entryDTO);
    }


}

