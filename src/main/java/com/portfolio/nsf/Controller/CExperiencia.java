
package com.portfolio.nsf.Controller;

import com.portfolio.nsf.Dto.dtoExperiencia;
import com.portfolio.nsf.Entity.Experiencia;
import com.portfolio.nsf.Security.Controller.Mensaje;
import com.portfolio.nsf.Service.ServExp;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")

public class CExperiencia {
    
    @Autowired
    ServExp servExp;
    
    // traer la lista de experiencias
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = servExp.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!servExp.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = servExp.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servExp.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        servExp.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    
    
    
    
    
    
    
    // crear una experiencia
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servExp.existsByNombreE(dtoexp.getNombreE())){
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(
                dtoexp.getNombreE(), 
                dtoexp.getDescripcionE(), 
                dtoexp.getPositionE(), 
                dtoexp.getModoE(), 
                dtoexp.getStartE(), 
                dtoexp.getEndE(), 
                dtoexp.getWebE(),  // se agrega aca 
                dtoexp.getImgE());
        
        servExp.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }
    
    // Actualizar una experiencia
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        if(!servExp.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(servExp.existsByNombreE(dtoexp.getNombreE()) && servExp.getByNombreE(dtoexp.getNombreE()).get().getId() !=id)
            return  new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoexp.getNombreE())) 
            return new ResponseEntity(new Mensaje("El nombre es obigatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = servExp.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE((dtoexp.getDescripcionE()));
        experiencia.setPositionE(dtoexp.getPositionE()); // este lo agregue
        experiencia.setModoE(dtoexp.getModoE());
        experiencia.setStartE(dtoexp.getStartE());
        experiencia.setEndE(dtoexp.getEndE());
        experiencia.setWebE(dtoexp.getWebE());
        experiencia.setImgE(dtoexp.getImgE());
        
        
        servExp.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"),HttpStatus.OK);
    }
    
    // Borrar una experiencia
    
   /* public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servExp.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        servExp.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }*/
    
}
