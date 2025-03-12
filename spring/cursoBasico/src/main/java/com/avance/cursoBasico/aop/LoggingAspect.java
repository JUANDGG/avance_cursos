package com.avance.cursoBasico.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;
/*
* Los aspecto son utiles por ejemplo cuando queremos guardar en logs los errores
* o cuando queremos notificar por ejemplo un cliente como sentry o eso
* */
/*
* o usar @Order en aspectos, pero sí es recomendable
*  cuando tienes múltiples aspectos y quieres definir el orden en que se ejecutan.
*
*
* */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
    //intercepto el servicio que muestra todos los usuarios
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //@Before : antes
    //@After : despues
    //@AfterReturnin : se ejecuta cuando un metodo o punto de corte returna algo
    //@AfterThrowind : se ejecuta cuando un metodo o punto de corte nos da un error
    //@Around : envuelve todo osea el before el after el alfert Return
    //@PointCut : nos da un punto de corte

    //este metodo guarda el punto de corte
    @Pointcut("execution(* com.avance.cursoBasico.servicesRest.UserServiceImpl.getAllUsers(..))")
    private void getPont() {}

    @AfterReturning(pointcut = "getPont()", returning = "result")
    public void logBeforeMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        /*yo podria hacer muchas cosas como por ejemplo segui metodos que devuelven
         errores para registrar esos errores en logs*/
        logger.info("📌 [LOG] Método: " + methodName);
        logger.info("📌 [LOG] Parámetros: " + args);
        logger.info("📌 [LOG] Retorno: " + result);
    }

    //envuelve todo el ciclo de vida de un methddo
    @Around("execution(* com.avance.cursoBasico.servicesRest.UserServiceImpl.getAllUsers(..))")
    //con el throws en los metodos puedo obligar a manejar los errores como tal
    //Si throws está en la firma del método, la excepción debe manejarse donde se llame
    public Object loggerAroung(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object resultObject = null;
        try {
            resultObject= joinPoint.proceed();
            logger.info("AROUND :" + resultObject);
            return resultObject;
        }catch (Throwable e) {
            logger.error(e.getMessage());
        }
        return resultObject;
    }
}