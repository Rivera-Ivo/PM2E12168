package com.example.pm2e12168.Models;

import java.sql.Blob;

public class persona
{
    private Integer id;
    private String pais;
    private String nombre;
    private Integer telefono;
    private String nota;
    private Blob foto;


    /*Constructor*/
    public persona(Integer id, String pais, String nombre, Integer telefono, String nota, Blob foto) {
        this.id = id;
        this.pais = pais;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nota = nota;
        this.foto = foto;
    }

    public persona(){
    }

    /*
    * Getter y Setter*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }
}

