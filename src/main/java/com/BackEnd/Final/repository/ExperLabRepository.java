package com.BackEnd.Final.repository;

import com.BackEnd.Final.models.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperLabRepository extends JpaRepository<ExperienciaLaboral, Long> {
}