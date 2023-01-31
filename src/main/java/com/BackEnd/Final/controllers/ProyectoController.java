package com.BackEnd.Final.controllers;

import com.BackEnd.Final.models.Proyecto;
import com.BackEnd.Final.payload.response.MessageResponse;
import com.BackEnd.Final.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/proyectos")
@CrossOrigin(origins = {"http://localhost:4200/",  "https://portfolio-sebastian-7ebf5.web.app/"})
public class ProyectoController {
    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        List<Proyecto> lista = proyectoService.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Proyecto proyecto){
        proyectoService.create(proyecto);
        return new ResponseEntity<>(new MessageResponse("El proyecto fue creado exitosamente"), HttpStatus.CREATED);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<?> details(@PathVariable("id") Long id){
        Proyecto proyecto = proyectoService.detail(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") Long id, @RequestBody Proyecto newProyecto){
        Proyecto proyecto = proyectoService.detail(id);
        proyecto.setNombreProyecto(newProyecto.getNombreProyecto());
        proyecto.setDescripcion(newProyecto.getDescripcion());
        proyecto.setImg(newProyecto.getImg());
        proyecto.setUrl(newProyecto.getUrl());
        proyectoService.create(proyecto);
        return new ResponseEntity<>(new MessageResponse("el proyecto se ha actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        proyectoService.delete(id);
        return new ResponseEntity<>(new MessageResponse("el proyecto fue eliminado exitosamente"), HttpStatus.OK);
    }
}
