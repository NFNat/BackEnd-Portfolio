
package com.portfolio.nsf.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    
    @NotBlank
    private String schoolEd;
    @NotBlank
    private String titleEd;
    @NotBlank
    private String careerEd;
    @NotBlank
    private String startEd;
    @NotBlank
    private String  endEd;
    @NotBlank
    private String webEd;
    @NotBlank
    private String imgEd;

    public dtoEducacion() {
    }

    public dtoEducacion(String schoolEd, String titleEd, String careerEd, String startEd, String endEd, String webEd, String imgEd) {
        this.schoolEd = schoolEd;
        this.titleEd = titleEd;
        this.careerEd = careerEd;
        this.startEd = startEd;
        this.endEd = endEd;
        this.webEd = webEd;
        this.imgEd = imgEd;
    }

    public String getImgEd() {
        return imgEd;
    }

    public void setImgEd(String imgEd) {
        this.imgEd = imgEd;
    }

    public String getSchoolEd() {
        return schoolEd;
    }

    public void setSchoolEd(String schoolEd) {
        this.schoolEd = schoolEd;
    }

    public String getTitleEd() {
        return titleEd;
    }

    public void setTitleEd(String titleEd) {
        this.titleEd = titleEd;
    }

    public String getCareerEd() {
        return careerEd;
    }

    public void setCareerEd(String careerEd) {
        this.careerEd = careerEd;
    }

    public String getStartEd() {
        return startEd;
    }

    public void setStartEd(String startEd) {
        this.startEd = startEd;
    }

    public String getEndEd() {
        return endEd;
    }

    public void setEndEd(String endEd) {
        this.endEd = endEd;
    }

    public String getWebEd() {
        return webEd;
    }

    public void setWebEd(String webEd) {
        this.webEd = webEd;
    }
    
    
    
    
}
