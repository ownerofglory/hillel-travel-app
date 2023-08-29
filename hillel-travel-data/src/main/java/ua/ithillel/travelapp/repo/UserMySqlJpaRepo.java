package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ua.ithillel.travelapp.model.entity.User;


@Repository
@RequiredArgsConstructor
public class UserMySqlJpaRepo implements UserRepo {
    private final SessionFactory sessionFactory;


    @Override
    public User save(User user) {
        EntityManager entityManager = sessionFactory.createEntityManager();
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
        EntityManager entityManager = sessionFactory.createEntityManager();
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
