package com.BackEnd.Final.models;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreEmpresa;
    private String cargo;
    private String fechaDeEntrada;
    private String fechaDeSalida;
    private String logo;
    private String ciudad;
    private String pais;

    private ArrayList<String> tareas;

    public ExperienciaLaboral() {
        this.tareas = new ArrayList<>();
    }

    public ExperienciaLaboral(String nombreEmpresa, String cargo, String fechaDeEntrada,
                              String fechaDeSalida, String logo, String ciudad, String pais) {
        this.nombreEmpresa = nombreEmpresa;
        this.cargo = cargo;
        this.fechaDeEntrada = fechaDeEntrada;
        this.fechaDeSalida = fechaDeSalida;
        this.logo = logo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tareas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getnombreEmpresa() {
        return nombreEmpresa;
    }

    public void setnombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(String fechaDeEntrada) {
        this.fechaDeEntrada = fechaDeEntrada;
    }

    public String getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(String fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public ArrayList<String> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<String> tareas) {
        this.tareas = tareas;
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