# 📌 Anotaciones en Spring Boot que son Singleton por defecto

En **Spring Boot**, las siguientes anotaciones crean **un único objeto osea PATRON DE DISEÑP SIGLETON** 

## 🔹 1. Anotaciones de Componentes Generales
- `@Component` → Define un **componente genérico** en el contenedor de Spring.

## 🔹 2. Anotaciones de la Capa de Servicio
- `@Service` → Indica que la clase contiene **lógica de negocio**.

## 🔹 3. Anotaciones de la Capa de Persistencia
- `@Repository` → Marca una clase como un **repositorio de acceso a datos**.

## 🔹 4. Anotaciones de la Capa de Controladores
- `@Controller` → Define un **controlador MVC** para manejar vistas (Thymeleaf, JSP).
- `@RestController` → Extiende `@Controller` y `@ResponseBody`, utilizado para **APIs RESTful**.

## 🔹 5. Otras Anotaciones Relacionadas con Beans
- `@Configuration` → Define una **clase de configuración** que provee beans.
- `@Bean` → Define un **bean administrado por Spring**, con **Singleton** por defecto.
- `@RestControllerAdvice` → Maneja **excepciones globales** en controladores REST.
- `@ControllerAdvice` → Maneja **excepciones globales** en controladores MVC.

---

## ⚡ ¿Cómo cambiar el alcance de un Bean?
Si necesitas que un bean **NO sea Singleton**, puedes modificarlo con:

```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")  // Cambia de ser sigleton a crear una cada vez que se llame
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("Nueva instancia creada");
    }
}