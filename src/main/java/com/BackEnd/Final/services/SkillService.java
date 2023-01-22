package com.BackEnd.Final.services;

import com.BackEnd.Final.models.Skill;
import com.BackEnd.Final.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SkillService {
    @Autowired
    SkillRepository skillRepository;

    public List<Skill> list(){
        return skillRepository.findAll();
    }
    public Skill detail(Long id){
        return skillRepository.findById(id).orElse(null);
    }
    public void create(Skill skill){
        skillRepository.save(skill);
    }
    public void delete(Long id){
        skillRepository.deleteById(id);
    }
}
