
package com.portfolio.nsf.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    
    @NotNull
    @Size(min=1, max=50, message="El campo debe contener entre 1 y 50 caracteres")
    private String nombre;
    
    @NotNull
    @Size(min=1, max=50, message="El campo debe contener entre 1 y 50 caracteres")
    private String apellido;
    
    @Size(min=1, max=100, message="El campo debe contener entre 1 y 100 caracteres")
    private String img;
    
    @Size(min=1, max=100, message="El campo debe contener entre 1 y 100 caracteres")
    private String posicion;
    
    @Size(min=1, max=100, message="El campo debe contener entre 1 y 100 caracteres")
    private String scope;
    
    @Size(min=1, max=100, message="El campo debe contener entre 1 y 100 caracteres")
    private String ciudad;
    
    @Size(min=1, max=100, message="El campo debe contener entre 1 y 200 caracteres")
    private String about;
}

