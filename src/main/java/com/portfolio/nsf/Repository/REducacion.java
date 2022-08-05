
package com.portfolio.nsf.Repository;

import com.portfolio.nsf.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findBySchoolEd(String schoolEd);
    public boolean existsBySchoolEd(String schoolEd);
    
    
}
