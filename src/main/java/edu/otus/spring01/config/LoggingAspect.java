package edu.otus.spring01.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* edu.otus.spring01.runner.*.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.printf("Before advise %s\n", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        System.out.printf("After advice %s, result: %s\n", joinPoint.getSignature(), result);

    }


}
