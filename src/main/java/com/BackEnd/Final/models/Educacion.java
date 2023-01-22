package com.BackEnd.Final.models;

import javax.persistence.*;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreInstitucion;
    private String titulo;
    private String fechaDeIngreso;
    private String fechaDeEgreso;
    private String logo;
    private String ciudad;
    private String pais;

    public Educacion() {
    }

    public Educacion(String nombreInstitucion, String titulo, String fechaDeIngreso,
                     String fechaDeEgreso, String logo, String ciudad, String pais) {
        this.nombreInstitucion = nombreInstitucion;
        this.titulo = titulo;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeEgreso = fechaDeEgreso;
        this.logo = logo;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getFechaDeEgreso() {
        return fechaDeEgreso;
    }

    public void setFechaDeEgreso(String fechaDeEgreso) {
        this.fechaDeEgreso = fechaDeEgreso;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
