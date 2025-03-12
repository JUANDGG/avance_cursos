package com.avance.cursoBasico.inyeccionDependencias;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


/*primary le indica a spring cual implementacion debe de coger, en este caso
* vemos que cla clase Dependenci2impl implementa la interfas dependecia , y otra clase tambien lo hace
*  entonces generaria, entonce con primary le diriamos a spring que tome esa implementacion en concreto
*
* */
//@Primary
@Component("Dependencia2")
/*Se crea una nueva instancia del bean en cada petición HTTP.
Dura hasta que la solicitud finaliza (después de enviar la respuesta al cliente).
Cada usuario obtendrá su propia instancia del bean dentro de una misma petición.

Anotación	Duración del Bean
@Singleton (por defecto)	Dura toda la aplicación (una única instancia para todos).
@Prototype	Crea una nueva instancia en cada inyección.
@RequestScope	Dura solo una petición HTTP.
@SessionScope	Dura toda la sesión del usuario.
@ApplicationScope	Dura toda la vida de la aplicación (similar a Singleton pero global).

*/

@Configuration
@RequestScope
public class Dependencia2Impl implements Dependecia{

    @Override
    public void define() {
        System.out.println("Dependencia2Impl");
    }
}
