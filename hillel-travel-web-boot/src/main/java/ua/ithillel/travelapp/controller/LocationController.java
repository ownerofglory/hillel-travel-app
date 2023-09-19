package ua.ithillel.travelapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.travelapp.model.dto.BoundingBoxDTO;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.service.LocationService;

import java.util.List;

@RequestMapping("/locations")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = {HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE})
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<LocationDTO> getById(@PathVariable("id") Long id) {
        LocationDTO locationById = locationService.getLocationById(id);
        return ResponseEntity.ok(locationById);
    }

    @PostMapping("/search")
    public @ResponseBody
    ResponseEntity<List<LocationDTO>> search(@RequestBody BoundingBoxDTO bbox) {
        List<LocationDTO> locationForBoundingBox = locationService.getLocationForBoundingBox(bbox);

        return ResponseEntity.ok(locationForBoundingBox);
    }
}
