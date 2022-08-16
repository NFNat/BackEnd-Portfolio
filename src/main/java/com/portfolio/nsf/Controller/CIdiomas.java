
package com.portfolio.nsf.Controller;



import com.portfolio.nsf.Dto.dtoIdiomas;
import com.portfolio.nsf.Entity.Idiomas;
import com.portfolio.nsf.Security.Controller.Mensaje;
import com.portfolio.nsf.Service.ServIdi;
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
@RequestMapping("/idiomas")
@CrossOrigin(origins = "https://frontendnf.web.app")
public class CIdiomas {
    @Autowired
    ServIdi servIdi;
    
    
     @GetMapping("/lista")
    public ResponseEntity<List<Idiomas>> list(){
        List<Idiomas> list = servIdi.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Idiomas> getById(@PathVariable("id") int id){
        if(!servIdi.existsById(id)){
            return new ResponseEntity(new Mensaje ("no Existe"), HttpStatus.NOT_FOUND);
        }
        Idiomas idiomas = servIdi.getOne(id).get();
        return new ResponseEntity(idiomas, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servIdi.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        servIdi.delete(id);
        return new ResponseEntity(new Mensaje ("Idioma Eliminado"), HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoIdiomas dtoidi){
        if (StringUtils.isBlank(dtoidi.getIdioma())) {
            return new ResponseEntity(new Mensaje ("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (servIdi.existsByIdioma(dtoidi.getIdioma())){
            return new ResponseEntity(new Mensaje("Idioma ya existente"), HttpStatus.BAD_REQUEST);
        }
        
       Idiomas idiomas = new Idiomas(
                dtoidi.getIdioma(),                
                dtoidi.getNivel(),
               dtoidi.getProgressId());
        
        servIdi.save(idiomas);
        return new ResponseEntity(new Mensaje("Idioma Creado"), HttpStatus.OK);
     }
    
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoIdiomas dtoidi){
        if (!servIdi.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.NOT_FOUND);
        }
        if(servIdi.existsByIdioma(dtoidi.getIdioma()) && servIdi.getByIdioma(dtoidi.getIdioma()).get().getId() !=id){
            
            return new ResponseEntity(new Mensaje("Idioma existente"), HttpStatus.BAD_REQUEST); //// aca dijo que la descripcion(ver que campo es equivaklente mio, lo tengo que hacer yo
        }
        
        if(StringUtils.isBlank(dtoidi.getIdioma())){
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Idiomas idiomas = servIdi.getOne(id).get();
        idiomas.setIdioma(dtoidi.getIdioma());
        idiomas.setNivel(dtoidi.getNivel());
        idiomas.setProgressId(dtoidi.getProgressId());
        
        
        servIdi.save(idiomas);
        return new ResponseEntity(new Mensaje ("se actualizo correctamente el idioma"), HttpStatus.OK);
        
        
    
    }
    
    
    
    
    
}
