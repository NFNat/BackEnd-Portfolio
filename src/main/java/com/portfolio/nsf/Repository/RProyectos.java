
package com.portfolio.nsf.Repository;

import com.portfolio.nsf.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    public Optional <Proyectos> findByNombreProy(String nombreProy);
    public Boolean existsByNombreProy(String nombreProy);
    
}
