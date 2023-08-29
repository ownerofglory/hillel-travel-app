package ua.ithillel.travelapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ua.ithillel.travelapp.model.entity.Location;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.repo.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-annotation.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        ;

        try (
                EntityManagerFactory entityManagerFactory
                        = Persistence.createEntityManagerFactory("travelapp");
                SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry)) {


            EntityManager entityManager = sessionFactory.createEntityManager();

            System.out.println();


//            UserRepo userRepo = new UserMySqlJpaRepo(entityManagerFactory);
//            TravelEntryRepo entryRepo = new TravelEntryMySqlJpaRepo(entityManagerFactory);
//            LocationRepo locationRepo = new LocationMySqlJpaRepo(entityManagerFactory);

//            User user = new User();
//            user.setName("Max1 Mustermann1");
//            user.setEmail("max1.m@mail.com");
//            user.setPassword("1111");
//
//            TravelEntry travelEntry = new TravelEntry();
//            travelEntry.setTitle("My First trip to Africa");
//            travelEntry.setDescription("It's been nice");
//            travelEntry.setEntryDate(new Date());
//
//            travelEntry.setUser(user);
//            List<TravelEntry> travels = new ArrayList<>();
//
//            travels.add(travelEntry);
//
//            user.setTravelEntries(travels);
//
//            userRepo.save(user);

//            User user = userRepo.find(6L);

//            List<TravelEntry> byUserId = entryRepo.findByUserId(user.getId());
//
//            TravelEntry travelEntry = new TravelEntry();
//            travelEntry.setEntryDate(new Date());
//            travelEntry.setDescription("sfsf");
//            travelEntry.setTitle("drsffsrgr");
//            travelEntry.setUser(user);

//            entryRepo.save(travelEntry);

//            TravelEntry travelEntry = new TravelEntry();
//            travelEntry.setEntryDate(new Date());
//            travelEntry.setDescription("sfsf");
//            travelEntry.setTitle("drsffsrgr");
//            travelEntry.setUser(user);
//
//            Location location = new Location();
//            location.setLocationName("Some location 1");
//            location.setLatitude(51.3);
//            location.setLongitude(23.7);
//            location.setTravelEntry(travelEntry);
//
//            travelEntry.setLocations(List.of(location));
//
//            entryRepo.save(travelEntry);
//
//            List<Location> locations = locationRepo.findLocations(52.2, 24.0, 50.1, 23.0, 100);
//
//            System.out.println();

        } catch (Exception e) {
            System.out.println(e);
        }




    }
}
