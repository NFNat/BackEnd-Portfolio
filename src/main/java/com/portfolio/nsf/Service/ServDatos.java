
package com.portfolio.nsf.Service;

import com.portfolio.nsf.Entity.Datos;
import com.portfolio.nsf.Repository.RDatos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServDatos {
    @Autowired
    RDatos rDatos;
    
    
    
    public List<Datos> list(){
        return rDatos.findAll();
    }
    
    
    public Optional<Datos> getOne (int id){
        return rDatos.findById(id);    
    }
    
    public Optional<Datos> getByNombre(String nombre){
        return rDatos.findByNombre(nombre);
    
    }
    
    public void save(Datos nombre){
        rDatos.save(nombre);
    
    }
    
    public void delete(int id){
        rDatos.deleteById(id);    
    }
    
    public boolean existsById(int id){
        return rDatos.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rDatos.existsByNombre(nombre);
    }
    
}
