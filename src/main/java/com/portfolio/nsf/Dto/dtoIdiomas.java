
package com.portfolio.nsf.Dto;

import javax.validation.constraints.NotBlank;


public class dtoIdiomas {
    @NotBlank
    private String idioma;
    @NotBlank
    private String nivel;
    @NotBlank
    private Long progressId;

    public dtoIdiomas() {
    }

    public dtoIdiomas(String idioma, String nivel, Long progressId) {
        this.idioma = idioma;
        this.nivel = nivel;
        this.progressId = progressId;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }
    
    
    
}
