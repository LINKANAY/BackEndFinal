package com.BackEnd.Final.services;

import javax.transaction.Transactional;

import com.BackEnd.Final.models.Persona;
import com.BackEnd.Final.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> list() {
        return personaRepository.findAll();
    }

    public Persona verPersona(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    public Persona detail(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public void create(Persona persona) {
        personaRepository.save(persona);
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    public boolean existById(Long id) {return personaRepository.existsById(id); }
}
