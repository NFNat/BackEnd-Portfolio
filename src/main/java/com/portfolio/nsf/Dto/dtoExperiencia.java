
package com.portfolio.nsf.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    
    @NotBlank
    private String descripcionE;
    
    //agregados
    @NotBlank
    private String positionE;
    
    @NotBlank
    private String modoE;
            
    @NotBlank
    private String startE;
            
    @NotBlank
    private String endE;
            
    @NotBlank
    private String webE;
    
    @NotBlank
    private String imgE;




// Generar constructores, getters and setters

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String positionE, String modoE, String startE, String endE, String webE, String imgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        
        this.positionE = positionE;
        this.modoE = modoE;
        this.startE = startE;
        this.endE = endE;
        this.webE = webE;
        this.imgE = imgE;
    }

    public String getPositionE() {
        return positionE;
    }

    public void setPositionE(String positionE) {
        this.positionE = positionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    
    
    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getModoE() {
        return modoE;
    }

    public void setModoE(String modoE) {
        this.modoE = modoE;
    }

    public String getStartE() {
        return startE;
    }

    public void setStartE(String startE) {
        this.startE = startE;
    }

    public String getEndE() {
        return endE;
    }

    public void setEndE(String endE) {
        this.endE = endE;
    }

    public String getWebE() {
        return webE;
    }

    public void setWebE(String webE) {
        this.webE = webE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    
    
    
    
}
