package com.BackEnd.Final.controllers;

import com.BackEnd.Final.models.Educacion;
import com.BackEnd.Final.payload.response.MessageResponse;
import com.BackEnd.Final.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/educacion")
@CrossOrigin(origins = {"http://localhost:4200/",  "https://portfolio-sebastian-dd53c.web.app/"})
public class EducacionController {
    @Autowired
    EducacionService educacionService;
    @GetMapping("/list")
    public ResponseEntity<?> list(){
        List<Educacion> lista = educacionService.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Educacion educacion){
        educacionService.create(educacion);
        return new ResponseEntity<>(new MessageResponse("La education se creo exitosamente"), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Educacion newEducacion){
        Educacion educacion = educacionService.detail(id);
        educacion.setNombreInstitucion(newEducacion.getNombreInstitucion());
        educacion.setTitulo(newEducacion.getTitulo());
        educacion.setFechaDeIngreso(newEducacion.getFechaDeIngreso());
        educacion.setFechaDeEgreso(newEducacion.getFechaDeEgreso());
        educacion.setLogo(newEducacion.getLogo());
        educacion.setCiudad(newEducacion.getCiudad());
        educacion.setPais(newEducacion.getPais());
        educacionService.create(educacion);
        return new ResponseEntity<>(new MessageResponse("Se actualizo la educación"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        educacionService.delete(id);
        return new ResponseEntity<>(new MessageResponse("La educación se elimino exitosamente"), HttpStatus.OK);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long id){
        Educacion educacion = educacionService.detail(id);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
}
