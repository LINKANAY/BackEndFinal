package com.BackEnd.Final.controllers;

import com.BackEnd.Final.models.Persona;
import com.BackEnd.Final.payload.response.MessageResponse;
import com.BackEnd.Final.services.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/personas")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return new ResponseEntity<>(personaService.list(), HttpStatus.OK);
    }

    @GetMapping("/verPersona")
    public Persona verPersona(){
        return personaService.verPersona((long)1);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long id){
        if(!personaService.existById(id)){
            return new ResponseEntity<>(new MessageResponse("no existe esa persona"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personaService.detail(id), HttpStatus.OK);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
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
