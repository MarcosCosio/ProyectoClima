package com.principal;

import java.time.LocalDateTime;

public class Localidad {
    private String nombre;
    private String abr;
    private int codLoc;
    private Provincia prov;

    public Localidad(String nombre, String abr, int codLoc, Provincia prov) {
        this.nombre = nombre;
        this.abr = abr;
        this.codLoc = codLoc;
        this.prov = prov;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public int getCodLoc() {
        return codLoc;
    }

    public void setCodLoc(int codLoc) {
        this.codLoc = codLoc;
    }

    public Provincia getProv() {
        return prov;
    }

    public void setProv(Provincia prov) {
        this.prov = prov;
    }

}
