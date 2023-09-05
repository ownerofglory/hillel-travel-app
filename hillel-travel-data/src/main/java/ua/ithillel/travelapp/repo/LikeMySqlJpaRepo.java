package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.ithillel.travelapp.model.entity.Like;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikeMySqlJpaRepo implements LikeRepo {
    private final SessionFactory sessionFactory;

    @Override
    public Like find(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Like like = entityManager.find(Like.class, id);

            entityManager.getTransaction().commit();

            return like;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<Like> findByTravelEntryId(Long travelEntryId) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            TypedQuery<Like> query = entityManager.createQuery(
                    "SELECT l FROM like l WHERE l.travelEntry.id = :entryId",
                    Like.class);

            query.setParameter("entryId", travelEntryId);
            List<Like> resultList = query.getResultList();

            entityManager.getTransaction().commit();

            return resultList;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public Like save(Like like) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(like);
            entityManager.flush();

            entityManager.getTransaction().commit();

            return like;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public Like remove(Like like) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.remove(like);
            entityManager.flush();

            entityManager.getTransaction().commit();

            return like;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
