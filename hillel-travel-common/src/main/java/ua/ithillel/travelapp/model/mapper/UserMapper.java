package ua.ithillel.travelapp.model.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ithillel.travelapp.model.dto.TravelEntryDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@RequiredArgsConstructor
public abstract class UserMapper {
    @Autowired
    protected TravelEntryMapper travelEntryMapper;

//    @Mapping(source = "travelEntries", target = "travelEntries", qualifiedByName = "travelEntriesToTravelEntriesDTO")
    public abstract UserDTO userToUserDTO(User user);
    public abstract User userDTOToUser(UserDTO userDTO);

//    @Named("travelEntriesToTravelEntriesDTO")
//    public List<TravelEntryDTO> travelEntriesToTravelEntriesDTO(List<TravelEntry> travelEntries) {
//        return travelEntries.stream()
//                .map(travelEntryMapper::travelEntryToTravelEntryDTO)
//                .toList();
//    }
}
