package com.avance.cursoBasico.interceptores.ejemploBasico;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.http.client.ClientHttpRequestFactorySettings;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Component("course-interceptor")
public class CoursesUserInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CoursesUserInterceptor.class);
    private final ClientHttpRequestFactorySettings clientHttpRequestFactorySettings;

    public CoursesUserInterceptor(ClientHttpRequestFactorySettings clientHttpRequestFactorySettings) {
        this.clientHttpRequestFactorySettings = clientHttpRequestFactorySettings;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI(); // "/usuarios/123"
        String[] pathParts = path.split("/");
        String id = pathParts[pathParts.length - 1]; // Último segmento es el ID

        try {
            int userId = Integer.parseInt(id);
            if (userId == 0) {
                Map<String, String> info1 = new HashMap<>();
                info1.put("acceso", "denegado");
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(info1);

                response.setContentType("application/json");
                response.setStatus(401);
                response.getWriter().write(json);

                return false; // bloque la ejecucion del controlador
            }
        } catch (NumberFormatException e) {
            logger.error("Error al convertir el ID: " + id, e);
        }
        return true; //continua con la ejecucion
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
