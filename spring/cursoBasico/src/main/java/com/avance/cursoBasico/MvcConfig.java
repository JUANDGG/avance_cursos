package com.avance.cursoBasico;

import com.avance.cursoBasico.interceptores.HorarioInterseptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//registro el interceptor en spring
@Configuration
public class MvcConfig  implements WebMvcConfigurer {
    @Autowired
    private HandlerInterceptor handlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //se aplicaria solo a un solo contralor aunque se puede aplicar a varios si queremos
        //registry.addInterceptor(handlerInterceptor).addPathPatterns("/api/inter/foo","/api/inter/foo/{id}");
        //registry.addInterceptor(handlerInterceptor).addPathPatterns("/api/v1/courses/{id}");
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/mesa-ayuda/**");
        //tambien podemos excluir rutas
        //registry.addInterceptor(handlerInterceptor).excludePathPatterns("/api/inter/foo","/api/inter/foo/{id}");

    }
}
