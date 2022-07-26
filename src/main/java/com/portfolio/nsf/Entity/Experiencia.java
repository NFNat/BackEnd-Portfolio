
package com.portfolio.nsf.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    
    //agregados 
    private String positionE;
    private String modoE;
    private String startE;
    private String endE;
    private String webE;
    private String imgE;
    
    
    
    

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String positionE, String modoE, String startE, String endE, String webE,String imgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        
        this.positionE = positionE;
        this.modoE = modoE;
        this.startE = startE;
        this.endE = endE;
        this.webE = webE;
        this.imgE = imgE;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    
    
    public String getPositionE() {
        return positionE;
    }

    public void setPositionE(String positionE) {
        this.positionE = positionE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }
    
    
    
}
