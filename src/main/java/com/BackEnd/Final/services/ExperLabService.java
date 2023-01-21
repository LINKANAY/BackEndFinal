package com.BackEnd.Final.services;

import javax.transaction.Transactional;

import com.BackEnd.Final.models.ExperienciaLaboral;
import com.BackEnd.Final.repository.ExperLabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExperLabService {
    @Autowired
    ExperLabRepository expLabRepository;

    public List<ExperienciaLaboral> list() {
        return expLabRepository.findAll();
    }

    public ExperienciaLaboral detail(Long id) {
        return expLabRepository.findById(id).orElse(null);
    }

    public void create(ExperienciaLaboral expLab) {
        expLabRepository.save(expLab);
    }

    public void delete(Long id) {
        expLabRepository.deleteById(id);
    }
}
