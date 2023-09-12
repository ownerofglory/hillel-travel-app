package ua.ithillel.travelapp.model.mapper;

import org.junit.jupiter.api.Test;
import ua.ithillel.travelapp.model.dto.LikeDTO;
import ua.ithillel.travelapp.model.entity.Like;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LikeMapperTest extends MapperTestParent {
    @Test
    public void likeToLikeDTOTest_success() {
        Like like = mockLikes.get(0);

        LikeDTO likeDTO = likeMapper.likeToLikeDTO(like);

        assertNotNull(likeDTO);
        assertNotNull(likeDTO.getId());
    }
    @Test
    public void likeDTOToLikeTest_success() {
        LikeDTO likeDTO = mockLikeDTOs.get(0);

        Like like = likeMapper.likeDTOToLike(likeDTO);

        assertNotNull(like);
    }
}
