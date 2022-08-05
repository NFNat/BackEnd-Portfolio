
package com.portfolio.nsf.Controller;

import com.portfolio.nsf.Dto.dtoSkills;
import com.portfolio.nsf.Entity.Skills;
import com.portfolio.nsf.Security.Controller.Mensaje;
import com.portfolio.nsf.Service.ServSkills;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkills {
    @Autowired
    ServSkills servSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = servSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!servSkills.existsById(id)){
            return new ResponseEntity(new Mensaje ("no Existe"), HttpStatus.NOT_FOUND);
        }
        Skills skills = servSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        servSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skill Eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskill){
        if(StringUtils.isBlank(dtoskill.getNameSkill())){
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (servSkills.existsByNameSkill(dtoskill.getNameSkill())){
            return new ResponseEntity(new Mensaje("Skill ya agregada anteriormente"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = new Skills(
                dtoskill.getNameSkill(),
                dtoskill.getProgress(),
                dtoskill.getImgSkill());
        servSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill Agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill){
        if(!servSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(servSkills.existsByNameSkill(dtoskill.getNameSkill()) && servSkills.getByNameSkill(dtoskill.getNameSkill()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskill.getNameSkill())){
            return new ResponseEntity(new Mensaje ("Estae campo es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = servSkills.getOne(id).get();
        skills.setNameSkill(dtoskill.getNameSkill());
        skills.setProgress(dtoskill.getProgress());
        skills.setImgSkill(dtoskill.getImgSkill());
        
        servSkills.save(skills);
        return new ResponseEntity(new Mensaje("Se actualizó correctamente esta Skill"),HttpStatus.OK);
    }
    
    
}
