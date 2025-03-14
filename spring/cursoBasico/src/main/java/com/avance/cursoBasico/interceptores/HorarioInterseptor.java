package com.avance.cursoBasico.interceptores;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.ManyToOne;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component("mesa-ayuda-interceptor")
public class HorarioInterseptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //tomo la hora actual en la que se envia la peticion al servidor y dependiendo de la hora le doy acceso o no
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 16) {
            Map<String, String> info1 = new HashMap<>();
            info1.put("acceso", "denegado atendemos antes de las las 4 pm");
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(info1);

            response.setContentType("application/json");
            response.setStatus(401);
            response.getWriter().write(json);
            return false;
        }


        return true ;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
