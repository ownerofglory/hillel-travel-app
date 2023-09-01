package ua.ithillel.travelapp.repo;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.ithillel.travelapp.config.JpaTestConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {JpaTestConfig.class})
public class SpringRepoTestParent {
    @Autowired
    protected SessionFactory sessionFactory;
}
