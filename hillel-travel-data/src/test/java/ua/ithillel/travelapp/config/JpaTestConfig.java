package ua.ithillel.travelapp.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ua.ithillel.travelapp.model.entity.*;

import javax.sql.DataSource;

@Configuration
public class JpaTestConfig {
    @Bean
    public SessionFactory sessionFactory() {
        DataSource datasource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();

        var config = new org.hibernate.cfg.Configuration();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySetting(Environment.DATASOURCE, datasource)
                .build();

        return  new MetadataSources(registry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(TravelEntry.class)
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(Like.class)
                .addAnnotatedClass(Comment.class)
                .getMetadataBuilder()
                .build()
                .getSessionFactoryBuilder()
                .build();
    }
}
