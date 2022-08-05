
package com.portfolio.nsf.Repository;

import com.portfolio.nsf.Entity.Idiomas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RIdiomas extends JpaRepository<Idiomas, Integer>{
    public Optional<Idiomas> findByIdioma(String idioma);
    public boolean existsByIdioma(String idioma);
    
}
