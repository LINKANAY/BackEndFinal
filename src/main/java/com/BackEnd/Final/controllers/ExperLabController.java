
package com.BackEnd.Final.controllers;

import java.util.List;

import com.BackEnd.Final.models.ExperienciaLaboral;
import com.BackEnd.Final.payload.response.MessageResponse;
import com.BackEnd.Final.services.ExperLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/experLab")
@CrossOrigin(origins = {"http://localhost:4200/",  "https://portfolio-sebastian-dd53c.web.app/"})
public class ExperLabController {
    
    @Autowired
    ExperLabService experLabService;
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaLaboral experiencia){
        experLabService.create(experiencia);
        return new ResponseEntity<>(new MessageResponse("La experiencia laboral fue creada exitosamente"), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        experLabService.delete(id);
        return new ResponseEntity<>(new MessageResponse("La experiencia laboral fue eliminada exitosamente"), HttpStatus.OK);
    }
    
    @GetMapping ("/list")
    public ResponseEntity<?> list(){
        List<ExperienciaLaboral> lista = experLabService.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping ("/details/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long id){
        ExperienciaLaboral exp = experLabService.detail(id);
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExperienciaLaboral experiencia){
        ExperienciaLaboral expe = experLabService.detail(id);
        expe.setnombreEmpresa(experiencia.getnombreEmpresa());
        expe.setCargo(experiencia.getCargo());
        expe.setFechaDeEntrada(experiencia.getFechaDeEntrada());
        expe.setFechaDeSalida(experiencia.getFechaDeSalida());
        expe.setLogo(experiencia.getLogo());
        expe.setCiudad(experiencia.getCiudad());
        expe.setPais(experiencia.getPais());
        expe.setTareas(experiencia.getTareas());
        experLabService.create(expe);
        return new ResponseEntity<>(expe, HttpStatus.OK);
        
    }
    
}
