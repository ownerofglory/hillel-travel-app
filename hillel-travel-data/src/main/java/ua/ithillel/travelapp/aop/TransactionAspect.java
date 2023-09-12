package ua.ithillel.travelapp.aop;

import jakarta.persistence.EntityManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {
    @Autowired
    private SessionFactory sessionFactory;

    @Around("@annotation(jakarta.transaction.Transactional)")
    public Object aroundTransactionalMethod(ProceedingJoinPoint pjp) throws Throwable {
        // before method execution
        EntityManager entityManager = sessionFactory.createEntityManager();
        Object returnValue = null;

        try {
            entityManager.getTransaction().begin();

            returnValue = pjp.proceed();
            // after method execution

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return returnValue;
    }
}
