package ua.ithillel.travelapp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LoggingAspect {
    @Pointcut("execution(* ua.ithillel.travelapp.service..*.*(..))")
    private void serviceMethods() {}

    @Pointcut("execution(* ua.ithillel.travelapp.repo..*.*(..))")
    private void repoMethods() {}


    @Around("serviceMethods()")
    public Object aroundServiceMethod(ProceedingJoinPoint pjp) throws Throwable {
        // before method execution
        log.debug("Before executing {} with params {}",
                pjp.getSignature(), Arrays.toString(pjp.getArgs()));

        Object returnValue = pjp.proceed();
        // after method execution

        log.debug("After executing {}, returned value: {}", pjp.getSignature(), returnValue);

        return returnValue;
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "e")
    public void afterThrowingFromServiceMethod(Exception e) {
        log.error("Exception thrown: {}", e.getMessage());
    }

    @Around("repoMethods()")
    public Object aroundRepoMethod(ProceedingJoinPoint pjp) throws Throwable {
        // before method execution
        log.debug("Before executing {} with params {}",
                pjp.getSignature(), Arrays.toString(pjp.getArgs()));

        Object returnValue = pjp.proceed();
        // after method execution

        log.debug("After executing {}, returned value: {}", pjp.getSignature(), returnValue);

        return returnValue;
    }

    @AfterThrowing(pointcut = "repoMethods()", throwing = "e")
    public void afterThrowingFromRepoMethod(Exception e) {
        log.error("Exception thrown: {}", e.getMessage());
    }
}
