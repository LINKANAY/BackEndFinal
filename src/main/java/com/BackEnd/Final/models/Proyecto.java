package com.BackEnd.Final.models;

import javax.persistence.*;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreProyecto;
    private String descripcion;
    private String img;

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descripcion, String img) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }


}
