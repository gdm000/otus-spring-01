package edu.otus.spring01.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* edu.otus.spring01.*.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

    }


}
