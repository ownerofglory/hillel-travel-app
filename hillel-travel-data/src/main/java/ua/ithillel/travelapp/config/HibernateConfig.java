package ua.ithillel.travelapp.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ua.ithillel.travelapp.model.entity.*;

import java.util.Properties;

@Configuration
@PropertySource("classpath:jpa-config.properties")
public class HibernateConfig {
    @Value("${jpa.driverName:com.mysql.cj.jdbc.Driver}")
    private String jpaDriverName;
    @Value("${jpa.url}")
    private String jpaUrl;
    @Value("${jpa.username}")
    private String jpaDbUsername;
    @Value("${jpa.password}")
    private String jpaPassword;

    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        Properties props = new Properties();
        props.put("hibernate.connection.driver_class", jpaDriverName);
        props.put("hibernate.connection.url", jpaUrl);
        props.put("hibernate.connection.username", jpaDbUsername);
        props.put("hibernate.connection.password", jpaPassword);
        props.put("hibernate.current_session_context_class", "thread");

//        props.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//        props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hilleltraveldb");
//        props.put("hibernate.connection.username", "hillel");
//        props.put("hibernate.connection.password", "Hillel123");
//        props.put("hibernate.current_session_context_class", "thread");

        configuration.setProperties(props);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(TravelEntry.class);
        configuration.addAnnotatedClass(Location.class);
        configuration.addAnnotatedClass(Comment.class);
        configuration.addAnnotatedClass(Like.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Java Config serviceRegistry created");

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
}
