package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import ua.ithillel.travelapp.model.entity.Comment;
import ua.ithillel.travelapp.model.entity.TravelEntry;

import java.util.List;

public class CommentMySqlJpaRepo implements CommentRepo {
    private final EntityManagerFactory entityManagerFactory;

    public CommentMySqlJpaRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Comment> findByTravelEntryId(Long entryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            TypedQuery<Comment> query = entityManager.createQuery(
                    "SELECT c FROM comment c WHERE c.travelEntry.id = :entryId",
                    Comment.class);

            query.setParameter("entryId", entryId);
            List<Comment> resultList = query.getResultList();

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
    public Comment save(Comment comment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(comment);
            entityManager.flush();

            entityManager.getTransaction().commit();

            return comment;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public Comment remove(Comment comment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.remove(comment);
            entityManager.flush();

            entityManager.getTransaction().commit();

            return comment;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
