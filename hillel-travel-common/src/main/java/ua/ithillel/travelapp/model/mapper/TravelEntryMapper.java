package ua.ithillel.travelapp.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.entity.Comment;
import ua.ithillel.travelapp.model.entity.Like;
import ua.ithillel.travelapp.model.entity.Location;
import ua.ithillel.travelapp.model.entity.TravelEntry;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {LocationMapper.class})
public abstract class TravelEntryMapper {
    @Autowired
    protected LocationMapper locationMapper;

    @Mapping(source = "comments", target = "commentCount", qualifiedByName = "commentsToCommentCount")
    @Mapping(source = "likes", target = "likeCount", qualifiedByName = "likesToLikeCount")
    @Mapping(source = "locations", target = "locations", qualifiedByName = "locationToLocationsDTO")
    public abstract TravelEntryDTO travelEntryToTravelEntryDTO(TravelEntry travelEntry);

    public abstract TravelEntry travelEntryDTOToTravelEntry(TravelEntryDTO travelEntryDTO);

    @Named("commentsToCommentCount")
    public int commentsToCommentCount(List<Comment> comments) {
        if (comments.isEmpty()) {
            return 0;
        }
        return comments.size();
    }

    @Named("likesToLikeCount")
    public int likesToLikeCount(List<Like> likes) {
        if (likes.isEmpty()) {
            return 0;
        }
        return likes.size();
    }

    @Named("locationToLocationsDTO")
    public List<LocationDTO> locationToLocationsDTO(List<Location> locations) {
        return locations.stream().map(location ->
                new Location(location.getId(),
                        location.getLatitude(),
                        location.getLongitude(),
                        location.getLocationName(),
                        null))
                .map(locationMapper::locationToLocationDTO)
                .toList();
    }
}
