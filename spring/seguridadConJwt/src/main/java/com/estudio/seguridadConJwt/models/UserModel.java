package com.estudio.seguridadConJwt.models;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;
import java.util.List;



/* 
CascadeType	Descripción	Ejemplo
ALL	Aplica todas las cascadas (PERSIST, MERGE, REMOVE, REFRESH, DETACH).	Si eliminas una entidad, también elimina las relacionadas.
PERSIST	Si guardas la entidad principal, también guarda las relacionadas.	entityManager.persist(parent) también guardará sus hijos.
MERGE	Si actualizas la entidad principal, también actualiza las relacionadas.	entityManager.merge(parent) actualizará los hijos.
REMOVE	Si eliminas la entidad principal, también elimina las relacionadas.	entityManager.remove(parent) eliminará sus hijos.
REFRESH	Si recargas la entidad principal desde la base de datos, también recarga las relacionadas.	entityManager.refresh(parent) actualizará los hijos con los datos actuales de la BD.
DETACH	Si desvinculas la entidad principal del contexto de persistencia, también desvincula las relacionadas.	entityManager.detach(parent) quitará el control de JPA sobre sus hijos. */
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id ;

    @Column(nullable = false)
    private String email ;


    @Column(nullable = false)
    private String password;

   /*  
    @ManyToMany(fetch = FetchType.EAGER,targetEntity = RoleModel.class,cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_role", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "id_role"), // Columna que referencia a Role
        inverseJoinColumns = @JoinColumn(name = "id_user") // Columna que referencia a user
    ) */
    //private List<RoleModel> role ;
    
}
