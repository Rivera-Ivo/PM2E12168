package com.example.pm2e12168.Models;

import com.example.pm2e12168.Configuracion.Contactos;

public class pais {

    private Integer id;
    private String pais;

    public pais(Integer id, String pais) {
        this.id = id;
        this.pais = pais;
    }

    public pais(){
    }

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
}
