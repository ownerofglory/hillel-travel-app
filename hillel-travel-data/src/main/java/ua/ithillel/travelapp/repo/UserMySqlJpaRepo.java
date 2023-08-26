package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import ua.ithillel.travelapp.model.entity.User;

public class UserMySqlJpaRepo implements UserRepo {
    private final EntityManagerFactory entityManagerFactory;

    public UserMySqlJpaRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public User save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(user);
            entityManager.flush();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return user;
    }

    @Override
    public User find(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            User user = entityManager.find(User.class, id);

            entityManager.getTransaction().commit();

            return user;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return null;
    }
}
