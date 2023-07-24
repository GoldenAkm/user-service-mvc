package com.user.mvc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.GetMapping *)")
    public void withinGetMappingMethods() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.PostMapping *)")
    public void withinPostMappingMethods() {
    }

    @Before("execution(* com.user.mvc.service.UserService.getUserByUsername(..))")
    public void logBeforeGetUserByUsernameMethod(JoinPoint joinPoint) {
        log.info("A log before request for getUserByUsername method. Location is" + joinPoint.getTarget());
        joinPointArgs(joinPoint);
    }

    @Before("execution(* com.user.mvc.service.UserService.addUser(..))")
    public void logBeforeAddUserMethod(JoinPoint joinPoint) {
        log.info("A log before request for addUser method. Location is " + joinPoint.getTarget());
        joinPointArgs(joinPoint);
    }

    @AfterThrowing("execution(* com.user.mvc.service.UserService.getUserByUsername(..))")
    public void logAfterThrowingGetUserByUsername(JoinPoint joinPoint) {
        log.error("Exception thrown in getUserByUsername method. Location is" + joinPoint.getTarget());
        joinPointArgs(joinPoint);
    }

    @AfterThrowing("execution(* com.user.mvc.service.UserService.addUser(..))")
    public void logAfterThrowingAddUser(JoinPoint joinPoint) {
        log.error("Exception thrown in addUser method. Location is" + joinPoint.getTarget());
        joinPointArgs(joinPoint);
    }

    @AfterThrowing("within(com.user.mvc.controller.UserController)")
    public void logAfterThrowingUserController(JoinPoint joinPoint) {
        log.error("Exception thrown in UserController=" + joinPoint.getTarget());
    }

    @AfterThrowing("withinPostMappingMethods()")
    public void logAfterThrowingPostMappingMethods(JoinPoint joinPoint) {
        log.error("Exception thrown in @PostMapping methods. The method is=" + joinPoint.getTarget());
    }

    @AfterThrowing("withinGetMappingMethods()")
    public void logAfterThrowingGetMappingMethods(JoinPoint joinPoint) {
        log.error("Exception thrown in @GetMapping methods. The method is=" + joinPoint.getTarget());
    }
    private void joinPointArgs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info(Arrays.toString(args));
    }

}
