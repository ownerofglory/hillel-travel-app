package ua.ithillel.travelapp.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.ithillel.travelapp.model.entity.Location;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LocationMySqlJpaRepo implements LocationRepo {
    private final SessionFactory sessionFactory;

    @Override
    public List<Location> findLocations(double neLat, double neLong, double swLat, double swLong, int limit) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            TypedQuery<Location> query = entityManager.createQuery("SELECT l FROM location l " +
                    "WHERE l.latitude BETWEEN :swLat AND :neLat " +
                    "AND l.longitude BETWEEN :swLong AND :neLong ", Location.class);

            query.setParameter("swLat", swLat);
            query.setParameter("neLat", neLat);
            query.setParameter("swLong", swLong);
            query.setParameter("neLong", neLong);

            List<Location> resultList = query.getResultList();



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
    public Location find(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {

            Location location = entityManager.find(Location.class, id);

            entityManager.getTransaction().commit();

            return location;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
