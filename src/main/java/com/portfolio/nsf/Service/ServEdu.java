
package com.portfolio.nsf.Service;

import com.portfolio.nsf.Entity.Educacion;
import com.portfolio.nsf.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServEdu {
    @Autowired
    REducacion rEducacion;
    
    
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    
    public Optional<Educacion> getOne (int id){
        return rEducacion.findById(id);
    
    }
    
    public Optional<Educacion> getBySchoolEd(String schoolEd){
        return rEducacion.findBySchoolEd(schoolEd);
    
    }
    
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);    
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsBySchoolEd(String schoolEd){
        return rEducacion.existsBySchoolEd(schoolEd);
    }
    
}
