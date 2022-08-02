
package com.portfolio.nsf.Controller;

import com.portfolio.nsf.Dto.dtoEducacion;
import com.portfolio.nsf.Entity.Educacion;
import com.portfolio.nsf.Security.Controller.Mensaje;
import com.portfolio.nsf.Service.ServEdu;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    ServEdu servEdu;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = servEdu.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!servEdu.existsById(id)){
            return new ResponseEntity(new Mensaje ("no Existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = servEdu.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("Id") int id){
        if(!servEdu.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        servEdu.delete(id);
        return new ResponseEntity(new Mensaje ("Educacion Eliminada"), HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if (StringUtils.isBlank(dtoedu.getSchoolEd())) {
            return new ResponseEntity(new Mensaje ("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (servEdu.existsBySchoolEd(dtoedu.getSchoolEd())){
            return new ResponseEntity(new Mensaje("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
                dtoedu.getSchoolEd(),
                dtoedu.getTitleEd(),
                dtoedu.getCareerEd(),
                dtoedu.getStartEd(),
                dtoedu.getEndEd(),
                dtoedu.getWebEd(),
                dtoedu.getImgEd());
        
        servEdu.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Creada"), HttpStatus.OK);
     }
    
    
    //// desde aca controlar
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        if (!servEdu.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.NOT_FOUND);
        }
        if(servEdu.existsBySchoolEd(dtoedu.getSchoolEd()) && servEdu.getBySchoolEd(dtoedu.getSchoolEd()).get().getId() !=id){
            
            return new ResponseEntity(new Mensaje("Educacion existente"), HttpStatus.BAD_REQUEST); //// aca dijo que la descripcion(ver que campo es equivaklente mio, lo tengo que hacer yo
        }
        
        if(StringUtils.isBlank(dtoedu.getSchoolEd())){
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = servEdu.getOne(id).get();
        educacion.setSchoolEd(dtoedu.getSchoolEd());
        educacion.setTitleEd(dtoedu.getTitleEd());
        educacion.setCareerEd(dtoedu.getCareerEd());
        educacion.setStartEd(dtoedu.getStartEd());
        educacion.setEndEd(dtoedu.getEndEd());
        educacion.setWebEd(dtoedu.getWebEd());
        educacion.setImgEd(dtoedu.getImgEd());
        
        servEdu.save(educacion);
        return new ResponseEntity(new Mensaje ("se actualizo correctamente la educacion"), HttpStatus.OK);
        
        
    
    }
    
    
    
    
    
    
}
