package com.principal;


import java.time.LocalDateTime;
import java.util.Date;

public class Clima {
    private Pronostico pronostico=new Pronostico();
    private Atmosfera atmosfera;
    private Viento viento;
    private Localidad localidad;

    public Clima(Dia dia, Atmosfera atmosfera, Viento viento, Localidad localidad) {
        this.pronostico.set1erDia(dia);
        this.atmosfera = atmosfera;
        this.viento = viento;
        this.localidad = localidad;
    }

    public void nuevoDia(float temp, String descr, LocalDateTime fecha, int nomSemana)
    {
        pronostico.nuevoDia(temp,descr,fecha,nomSemana);
    }


    public void diaSig (int max, int min,LocalDateTime fecha, String descripcion)
    {
        pronostico.diaSig(max,min,fecha,descripcion);
    }
    public Dia get1erDia ()
    {
        return pronostico.get1erdia();
    }

    public Pronostico getPronostico() {
        return pronostico;
    }

    public void setPronostico(Pronostico pronostico) {
        this.pronostico = pronostico;
    }

    public Atmosfera getAtmosfera() {
        return atmosfera;
    }

    public void setAtmosfera(Atmosfera atmosfera) {
        this.atmosfera = atmosfera;
    }

    public Viento getViento() {
        return viento;
    }

    public void setViento(Viento viento) {
        this.viento = viento;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

}
