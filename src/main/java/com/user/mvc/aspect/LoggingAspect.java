package com.user.mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

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
        System.out.println("Before Request for getting user");
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
        System.out.println("Around Requesting for getting user");

        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("There is a error with userService!!");
        }
        return proceed;
    }

    @AfterReturning("withinTransactionalMethods()")
    public void afterReturningAdvice(JoinPoint joinPoint) {
        System.out.println("Method executed successfully: " + joinPoint.getSignature());
    }


}
