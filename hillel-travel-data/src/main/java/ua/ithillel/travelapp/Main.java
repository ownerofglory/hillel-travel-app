package ua.ithillel.travelapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ua.ithillel.travelapp.model.entity.TravelEntry;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.repo.UserMySqlJpaRepo;
import ua.ithillel.travelapp.repo.UserRepo;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (
                EntityManagerFactory entityManagerFactory
                        = Persistence.createEntityManagerFactory("travelapp");) {

            UserRepo userRepo = new UserMySqlJpaRepo(entityManagerFactory);

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

            User user = userRepo.find(6L);

            System.out.println();

        } catch (Exception e) {
            System.out.println(e);
        }




    }
}
