
package com.portfolio.nsf.Service;
import com.portfolio.nsf.Entity.Idiomas;
import com.portfolio.nsf.Repository.RIdiomas;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
@Transactional
public class ServIdi {
    @Autowired
    RIdiomas rIdiomas;
    
    
    
    public List<Idiomas> list(){
        return rIdiomas.findAll();
    }
    
    
    
    public Optional<Idiomas> getOne (int id){
        return rIdiomas.findById(id);
    
    }
    
    public Optional<Idiomas> getByIdioma(String idioma){
        return rIdiomas.findByIdioma(idioma);
    
    }
    
    public void save(Idiomas idioma){
        rIdiomas.save(idioma);
    
    }
    
    public void delete(int id){
        rIdiomas.deleteById(id);    
    }
    
    public boolean existsById(int id){
        return rIdiomas.existsById(id);
    }
    
    public boolean existsByIdioma(String idioma){
        return rIdiomas.existsByIdioma(idioma);
    }
    
    
}
