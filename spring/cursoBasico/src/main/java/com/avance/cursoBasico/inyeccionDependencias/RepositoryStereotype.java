package com.avance.cursoBasico.inyeccionDependencias;

import org.springframework.stereotype.Repository;

/*
esta anotacion de estereotipo
 le dice a spring que la clase portadora es un dao
 osea que hacede alos datos ya sea de una base de datos etc...
 Repository no solo se usa para base de datos como tal si no por ejemplo todo
 que represente un asseso a datos como tal llamese base de datos relacionales o no relacionales ,
 archivos de texto plano consultas a una api y eso li qye llame a datos lo anotamos con esta anotacion de estereotipo
 llamese EL REPOSITORY ES UN COMOPONENETE MAS ESPECIFICO ES UNA SEMANTICA
*/


@Repository
public class RepositoryStereotype {

}
