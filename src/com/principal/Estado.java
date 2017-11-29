package com.principal;

import com.builder.EstadoBuilder;

import java.util.ArrayList;

public class Estado {
    private String nom;
    private String lettCod2;
    private String lettCod3;
    private int paisCod;



    public Estado(EstadoBuilder est) {
        this.nom = est.getNom();
        this.lettCod2 = est.getLettCod2();
        this.lettCod3 = est.getLettCod3();
        this.paisCod= est.getPaisCod();
       
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLettCod2() {
        return lettCod2;
    }

    public void setLettCod2(String lettCod2) {
        this.lettCod2 = lettCod2;
    }

    public String getLettCod3() {
        return lettCod3;
    }

    public void setLettCod3(String lettCod3) {
        this.lettCod3 = lettCod3;
    }



    public int getPaisCod() {
        return paisCod;
    }

    public void setPaisCod(int paisCod) {
        this.paisCod = paisCod;
    }
}