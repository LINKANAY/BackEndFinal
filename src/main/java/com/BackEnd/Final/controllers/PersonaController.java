package com.BackEnd.Final.controllers;

import com.BackEnd.Final.models.Persona;
import com.BackEnd.Final.payload.response.MessageResponse;
import com.BackEnd.Final.services.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/personas")
@CrossOrigin(origins = {"http://localhost:4200/",  "https://portfolio-sebastian-7ebf5.web.app/"})
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        List<Persona> lista = personaService.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long id){
        if(!personaService.existById(id)){
            return new ResponseEntity<>(new MessageResponse("no existe esa persona"), HttpStatus.NOT_FOUND);
        }
        Persona persona = personaService.detail(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Persona persona){
        if(StringUtils.isBlank(persona.getNombre())){
            return new ResponseEntity<>(new MessageResponse("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(persona.getApellido())){
            return new ResponseEntity<>(new MessageResponse("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        personaService.create(persona);
        return new ResponseEntity<>(new MessageResponse("Persona guardada"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") Long id,@RequestBody Persona persona){
        if(!personaService.existById(id)){
            return new ResponseEntity<>(new MessageResponse("no exista esa persona"), HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(persona.getNombre())){
            return new ResponseEntity<>(new MessageResponse("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(persona.getApellido())){
            return new ResponseEntity<>(new MessageResponse("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona perso = personaService.detail(id);
        perso.setNombre(persona.getNombre());
        perso.setApellido(persona.getApellido());
        perso.setSobreMi(persona.getSobreMi());
        perso.setTitulo(persona.getTitulo());
        perso.setFoto(persona.getFoto());
        perso.setCiudad(persona.getCiudad());
        perso.setPais(persona.getPais());
        personaService.create(perso);
        return new ResponseEntity<>(new MessageResponse("Persona actualizada"), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        if(!personaService.existById(id)){
            return new ResponseEntity<>(new MessageResponse("no exista esa persona"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity<>(new MessageResponse("Persona eliminada"), HttpStatus.OK);

    }

}
