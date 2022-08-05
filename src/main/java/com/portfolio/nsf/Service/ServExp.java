
package com.portfolio.nsf.Service;

import com.portfolio.nsf.Entity.Experiencia;
import com.portfolio.nsf.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServExp {
    @Autowired
    RExperiencia rExperiencia;
    
    //arma una lista con todas las experiencias que encuentre
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    // busca una experiencoa por el id
    
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
           
    }
    
    // busca la experiencia por el nombre
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return rExperiencia.findByNombreE(nombreE);
    
    }
    
    public void save(Experiencia expe){
        rExperiencia.save(expe);    
    }
    
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rExperiencia.existsByNombreE(nombreE);
    }
    
    
}
