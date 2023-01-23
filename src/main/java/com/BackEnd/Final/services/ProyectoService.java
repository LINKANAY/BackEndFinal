package com.BackEnd.Final.services;

import com.BackEnd.Final.models.Proyecto;
import com.BackEnd.Final.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    public List<Proyecto> list(){
        return proyectoRepository.findAll();
    }
    public Proyecto detail(Long id){
        return proyectoRepository.findById(id).orElse(null);
    }
    public void create(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }
    public void delete(Long id){
        proyectoRepository.deleteById(id);
    }
}
