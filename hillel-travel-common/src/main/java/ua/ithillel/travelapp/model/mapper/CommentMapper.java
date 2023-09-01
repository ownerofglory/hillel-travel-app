package ua.ithillel.travelapp.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import ua.ithillel.travelapp.model.dto.CommentDTO;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.model.entity.Comment;
import ua.ithillel.travelapp.model.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CommentMapper {
    @Mapping(source = "user", target = "user", qualifiedByName = "userToUserDTO")
    public abstract CommentDTO commentToCommentDTO(Comment comment);
    public abstract Comment commentDTOToComment(CommentDTO commentDTO);

    @Named("userToUserDTO")
    public UserDTO userToUserDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
