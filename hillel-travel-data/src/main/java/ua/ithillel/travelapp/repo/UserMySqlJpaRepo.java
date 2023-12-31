package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ua.ithillel.travelapp.model.entity.User;


@Repository // @Component
@Primary
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

    @Override
    public User findByUsername(String username) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            TypedQuery<User> query = entityManager.createQuery(
                    "SELECT u FROM user u WHERE u.email = :email",
                    User.class);

            query.setParameter("email", username);
            User user = query.getSingleResult();

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
