package com.BackEnd.Final.controllers;

import com.BackEnd.Final.models.Skill;
import com.BackEnd.Final.payload.response.MessageResponse;
import com.BackEnd.Final.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/skill")
@CrossOrigin(origins = {"http://localhost:4200/",  "https://portfolio-sebastian-dd53c.web.app/"})
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        List<Skill> lista = skillService.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Skill skill){
        skillService.create(skill);
        return new ResponseEntity<>(new MessageResponse("El skill fue creado exitosamente"), HttpStatus.CREATED);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<?> details(@PathVariable("id") Long id){
        Skill skill = skillService.detail(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") Long id, @RequestBody Skill newSkill){
        Skill skill = skillService.detail(id);
        skill.setNombreSkill(newSkill.getNombreSkill());
        skill.setPorcentaje(newSkill.getPorcentaje());
        skillService.create(skill);
        return new ResponseEntity<>(new MessageResponse("el skill se ha actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        skillService.delete(id);
        return new ResponseEntity<>(new MessageResponse("el skill fue eliminado exitosamente"), HttpStatus.OK);
    }

}
