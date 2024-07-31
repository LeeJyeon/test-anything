package com.example.anything.jpa.aspect;

import com.example.anything.jpa.entity.Customer;
import com.example.anything.jpa.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static org.springframework.core.io.support.SpringFactoriesLoader.FailureHandler.logging;

@Aspect
@Component
@Slf4j
public class JpaAspect {
    private final LogService logger;

    public JpaAspect(LogService logger) {
        this.logger = logger;
    }


    @Around("execution(* com.example.anything.jpa.service.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("controller arg {}", pjp.getArgs());
        Object result = null;
        try {
            result = pjp.proceed();
            logger.logging(pjp.getArgs()[0], true);
            return result;
        } catch (Exception e) {
            logger.logging(pjp.getArgs()[0], false);
            throw e;
        }
    }

}
