package com.avance.cursoBasico.inyeccionDependencias;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComponentDependencia {
    //PARA PODER USAR AUTOWIRED LA CLASE PORTADORA TIENE QUE SER UN COMPONENETE O EL ESTEREOTIPO DE UNO
    /*si tenemos 2 implementaciones de la misma interfaz tendriamos que decidir que implementacion
    * de la misma queremos usar
    * */
    @Autowired
    //para poder usar qualifier toca cambiarle el nombre al componente
    @Qualifier("Dependencia2")
    private  Dependecia dependecia;


    /*@Autowired
    ComponentDependencia(Dependecia dependecia) {
        this.dependecia = dependecia;
    }*/

    //SE PUEDE INYECTAR POR MEDIO DE SETTER SIQUIERO INYECTAR ESA DEPENDENCIA
  /*  @Autowired
    public void setDependecia(Dependecia dependecia) {

    }
*/


    public void define() {
        dependecia.define();
    }
}
