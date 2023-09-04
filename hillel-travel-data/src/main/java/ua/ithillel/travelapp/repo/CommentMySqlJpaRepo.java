package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.ithillel.travelapp.model.entity.Comment;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentMySqlJpaRepo implements CommentRepo {
    private final SessionFactory sessionFactory;

    @Override
    public List<Comment> findByTravelEntryId(Long entryId) {
        EntityManager entityManager = sessionFactory.createEntityManager();
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
        EntityManager entityManager = sessionFactory.createEntityManager();
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
        EntityManager entityManager = sessionFactory.createEntityManager();
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

    @Override
    public Comment find(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Comment comment = entityManager.find(Comment.class, id);
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
