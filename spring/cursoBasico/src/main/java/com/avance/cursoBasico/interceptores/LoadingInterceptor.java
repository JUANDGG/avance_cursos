package com.avance.cursoBasico.interceptores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//creo mi interceptor para interceptar perticiones http antes o depues de ser enviadas
@Component("loadingInterceptor")
public class LoadingInterceptor implements HandlerInterceptor {

    private static Logger loger = LoggerFactory.getLogger(LoadingInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod controller =( (HandlerMethod) handler);
        //devuelve el nombre del controlador com tal
        loger.info("\n" + controller.getMethod().getName());
        //donde esta declarado  el interceptor osea la clase que lo contiene
        loger.info(controller.getMethod().getDeclaringClass().getName());
        return HandlerInterceptor.super.preHandle(request, response, handler);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
