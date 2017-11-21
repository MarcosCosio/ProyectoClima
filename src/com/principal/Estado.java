package com.principal;

import java.util.ArrayList;

public class Estado {
    private String nom;
    private String lettCod2;
    private String lettCod3;
    private ArrayList<Provincia> prov=new ArrayList<>();


    public Estado(String nom, String lettCod2, String lettCod3) {
        this.nom = nom;
        this.lettCod2 = lettCod2;
        this.lettCod3 = lettCod3;
        System.out.println("Estado " + nom + " Guardado");
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

    public ArrayList<Provincia> getProv() {
        return prov;
    }

    public void setProv(Provincia provR) {
        prov.add(provR);
    }

}