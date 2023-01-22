package com.BackEnd.Final.services;

import com.BackEnd.Final.models.Educacion;
import com.BackEnd.Final.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    public List<Educacion> list() {
        return educacionRepository.findAll();
    }

    public Educacion detail(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    public void create(Educacion expLab) {
        educacionRepository.save(expLab);
    }

    public void delete(Long id) {
        educacionRepository.deleteById(id);
    }
}
