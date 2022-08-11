
package com.portfolio.nsf.Dto;

import javax.validation.constraints.NotBlank;


public class dtoDatos {
    @NotBlank    
    private String nombre;
    @NotBlank
    private String ocupacion;
    @NotBlank
    private String nivel;
    @NotBlank
    private String lugar;
    @NotBlank
    private String imagen;
    

    public dtoDatos() {
    }

    public dtoDatos(String nombre, String ocupacion, String nivel, String lugar, String imagen) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.nivel = nivel;
        this.lugar = lugar;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
}
