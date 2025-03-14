package com.avance.cursoBasico.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(1)
@Aspect
@Component
public class AspectTwo {

    private final Logger log = LoggerFactory.getLogger(AspectTwo.class);

    @After("execution(* com.avance.cursoBasico.servicesRest.UserServiceImpl.getAllUsers(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        //nombre del metodo
        String methodName = joinPoint.getSignature();

        //nombre de la clase contenedora
        String className = joinPoint.getSignature().getDeclaringTypeName();

        log.info(className + "." + methodName + "()");
    }


}
