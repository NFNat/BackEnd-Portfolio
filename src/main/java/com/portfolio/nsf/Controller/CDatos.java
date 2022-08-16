
package com.portfolio.nsf.Controller;

import com.portfolio.nsf.Dto.dtoDatos;
import com.portfolio.nsf.Entity.Datos;
import com.portfolio.nsf.Security.Controller.Mensaje;
import com.portfolio.nsf.Service.ServDatos;
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
@RequestMapping("/datos")
@CrossOrigin(origins = "https://frontendnf.web.app")
public class CDatos {
    @Autowired
    ServDatos servDatos;
    
    
    
     @GetMapping("/lista")
    public ResponseEntity<List<Datos>> list(){
        List<Datos> list = servDatos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Datos> getById(@PathVariable("id") int id){
        if(!servDatos.existsById(id)){
            return new ResponseEntity(new Mensaje ("no Existe"), HttpStatus.OK);
        }
        Datos datos = servDatos.getOne(id).get();
        return new ResponseEntity(datos, HttpStatus.OK);        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servDatos.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        servDatos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoDatos dtodatos){
        if(StringUtils.isBlank(dtodatos.getNombre())){
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (servDatos.existsByNombre(dtodatos.getNombre())){
            return new ResponseEntity(new Mensaje("Proyecto ya agregado anteriormente"), HttpStatus.BAD_REQUEST);
        }
        
        Datos datos = new Datos (
                dtodatos.getNombre(),
                dtodatos.getOcupacion(),
                dtodatos.getNivel(),
                dtodatos.getLugar(),
                dtodatos.getImagen()
        );
              
        servDatos.save(datos);
        return new ResponseEntity(new Mensaje("Datos Agregado"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoDatos dtodatos){
        if(!servDatos.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(servDatos.existsByNombre(dtodatos.getNombre()) && servDatos.getByNombre(dtodatos.getNombre()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtodatos.getNombre())){
            return new ResponseEntity(new Mensaje ("Este campo es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Datos datos = servDatos.getOne(id).get();
        datos.setNombre(dtodatos.getNombre());
        datos.setOcupacion(dtodatos.getOcupacion());
        datos.setNivel(dtodatos.getNivel());
        datos.setLugar(dtodatos.getLugar());
        datos.setImagen(dtodatos.getImagen());
        
        
                
        servDatos.save(datos);
        return new ResponseEntity(new Mensaje("Se actualizó correctamente"),HttpStatus.OK);
    }
    
    
}
