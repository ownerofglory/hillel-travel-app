package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import ua.ithillel.travelapp.model.entity.Like;

import java.util.List;

public class LikeMySqlJpaRepo implements LikeRepo {
    private final EntityManagerFactory entityManagerFactory;

    public LikeMySqlJpaRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Like> findByTravelEntryId(Long travelEntryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
