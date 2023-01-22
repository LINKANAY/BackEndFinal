package com.BackEnd.Final.models;

import javax.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreSkill;
    private double porcentaje;

    public Skill() {
    }

    public Skill(String nombreSkill, double porcentaje) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Long getId() {
        return id;
    }
}
