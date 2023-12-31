package ua.ithillel.travelapp.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ithillel.travelapp.model.dto.LocationDTO;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.entity.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {LocationMapper.class})
public abstract class TravelEntryMapper {
    @Autowired
    protected LocationMapper locationMapper;

    @Mapping(source = "comments", target = "commentCount", qualifiedByName = "commentsToCommentCount")
    @Mapping(source = "likes", target = "likeCount", qualifiedByName = "likesToLikeCount")
    @Mapping(source = "locations", target = "locations", qualifiedByName = "locationToLocationsDTO")
    @Mapping(source = "user", target = "userId", qualifiedByName = "userToUserId")
    public abstract TravelEntryDTO travelEntryToTravelEntryDTO(TravelEntry travelEntry);


    public abstract TravelEntry travelEntryDTOToTravelEntry(TravelEntryDTO travelEntryDTO);

    @Named("userToUserId")
    public Long userToUserId(User user) {
        if (user != null) {
            return user.getId();
        }
        return -1L;
    }

    @Named("commentsToCommentCount")
    public int commentsToCommentCount(List<Comment> comments) {
        if (comments == null || comments.isEmpty()) {
            return 0;
        }
        return comments.size();
    }

    @Named("likesToLikeCount")
    public int likesToLikeCount(List<Like> likes) {
        if (likes == null || likes.isEmpty()) {
            return 0;
        }
        return likes.size();
    }

    @Named("locationToLocationsDTO")
    public List<LocationDTO> locationToLocationsDTO(List<Location> locations) {
        if (locations == null || locations.isEmpty()) {
            return new ArrayList<>();
        }

        return locations.stream().map(location ->
                new Location(location.getId(),
                        location.getLatitude(),
                        location.getLongitude(),
                        location.getLocationName(),
                        location.getImageUrl(),
                        null))
                .map(locationMapper::locationToLocationDTO)
                .toList();
    }
}
