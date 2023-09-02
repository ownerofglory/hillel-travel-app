package ua.ithillel.travelapp.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.travelapp.model.mapper.*;

@Configuration
public class MapperTestConfig {
    @Bean
    public LocationMapper locationMapper() {
        return Mappers.getMapper(LocationMapper.class);
    }

    @Bean
    public TravelEntryMapper travelEntryMapper() {
        return Mappers.getMapper(TravelEntryMapper.class);
    }

    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }

    @Bean
    public LikeMapper likeMapper() {
        return Mappers.getMapper(LikeMapper.class);
    }

    @Bean
    public CommentMapper commentMapper() {
        return Mappers.getMapper(CommentMapper.class);
    }
}
