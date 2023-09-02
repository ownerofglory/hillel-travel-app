package ua.ithillel.travelapp.model.mapper;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.ithillel.travelapp.config.MapperTestConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MapperTestConfig.class})
public class MapperTestParent {
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected TravelEntryMapper travelEntryMapper;
    @Autowired
    protected LocationMapper locationMapper;
    @Autowired
    protected LikeMapper likeMapper;
    @Autowired
    protected CommentMapper commentMapper;
}
