
package com.portfolio.nsf.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String schoolEd;
    private String titleEd;
    private String careerEd;
    private String startEd;
    private String  endEd;
    private String webEd;
    private String imgEd;

    public Educacion() {
    }

    public Educacion(String schoolEd, String titleEd, String careerEd, String startEd, String endEd, String webEd, String imgEd) {
        this.schoolEd = schoolEd;
        this.titleEd = titleEd;
        this.careerEd = careerEd;
        this.startEd = startEd;
        this.endEd = endEd;
        this.webEd = webEd;
        this.imgEd = imgEd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImgEd() {
        return imgEd;
    }

    public void setImgEd(String imgEd) {
        this.imgEd = imgEd;
    }
    
    
    
    
    
        
        
       
        
    
    
    
}
