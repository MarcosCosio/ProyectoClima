package com.builder;

import com.principal.Estado;

public class EstadoBuilder {

    private EstadoBuilder builder=null;
    private String nom;
    private String lettCod2;
    private String lettCod3;
    private int paisCod;

    private EstadoBuilder(String nom, String lettCod2, String lettCod3, int paisCod) {
        this.nom = nom;
        this.lettCod2 = lettCod2;
        this.lettCod3 = lettCod3;
        this.paisCod = paisCod;
    }

    public Estado build(String nom, String lettCod2, String lettCod3, int paisCod)
    {
        if (builder==null)
        {
            builder=new EstadoBuilder(nom,lettCod2,lettCod3,paisCod);
            return new Estado(builder);
        }
        else
        {
            builder.setNom(nom);
            builder.setLettCod2(lettCod2);
            builder.setLettCod3(lettCod3);
            builder.setPaisCod(paisCod);
            return new Estado(builder);
        }
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

    public EstadoBuilder getBuilder() {

        return builder;
    }
}
