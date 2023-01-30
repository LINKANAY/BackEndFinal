package com.BackEnd.Final.models;

import javax.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreSkill;
    private double porcentaje;
    private String logo;

    public Skill() {
    }

    public Skill(String nombreSkill, double porcentaje, String logo) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
        this.logo = logo;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }
}
