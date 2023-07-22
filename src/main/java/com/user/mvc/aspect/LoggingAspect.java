package com.user.mvc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.user.mvc.service.UserService.getUserById(..))")
    public void userServiceGetUserByIdMethod() {
    }

    @Pointcut("within(@org.springframework.transaction.annotation.Transactional *)")
    public void withinTransactionalMethods() {
    }

    @Before("userServiceGetUserByIdMethod()")
    public void logBeforeServiceMethods() {
        log.info("Before Request for getting user");
    }

    @After("userServiceGetUserByIdMethod()")
    public void logAfterServiceMethods() {
        System.out.println("After Requesting for getting user");
    }

    @After("withinTransactionalMethods()")
    public void logAfterTransactionalMethods() {
        System.out.println("Transactional processes happened");
    }

    @AfterThrowing("userServiceGetUserByIdMethod()")
    public void logAfterThrowingServiceMethods() {
        System.out.println("After Throwing Requesting for getting user");
    }

    @Around("execution(* com.user.mvc.service.UserService.*(..))")
    public Object logAroundServiceMethods(ProceedingJoinPoint joinPoint) {
        return null;
    }

    @AfterReturning("withinTransactionalMethods()")
    public void afterReturningAdvice(JoinPoint joinPoint) {
        System.out.println("Method executed successfully: " + joinPoint.getSignature());
    }


}
