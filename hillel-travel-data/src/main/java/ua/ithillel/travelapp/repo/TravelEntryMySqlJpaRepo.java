package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import ua.ithillel.travelapp.model.entity.TravelEntry;

import java.util.List;

public class TravelEntryMySqlJpaRepo implements TravelEntryRepo {
    private final EntityManagerFactory entityManagerFactory;

    public TravelEntryMySqlJpaRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public TravelEntry find(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<TravelEntry> findByUserId(Long userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            TypedQuery<TravelEntry> query = entityManager.createQuery(
                    "SELECT t FROM travelEntry t WHERE t.user.id = :id",
                    TravelEntry.class);

            query.setParameter("id", userId);
            List<TravelEntry> resultList = query.getResultList();

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
    public TravelEntry save(TravelEntry travelEntry) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(travelEntry);
            entityManager.flush();

            entityManager.getTransaction().commit();

            return travelEntry;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public TravelEntry remove(TravelEntry travelEntry) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.remove(travelEntry);
            entityManager.flush();

            entityManager.getTransaction().commit();

            return travelEntry;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
