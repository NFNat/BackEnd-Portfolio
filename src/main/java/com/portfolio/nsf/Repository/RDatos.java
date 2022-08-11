
package com.portfolio.nsf.Repository;

import com.portfolio.nsf.Entity.Datos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RDatos extends JpaRepository<Datos, Integer> {
    
    public Optional <Datos> findByNombre(String nombre);
    public Boolean existsByNombre(String nombre);
    
}
