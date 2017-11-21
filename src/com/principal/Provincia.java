package com.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;


public class Provincia {



    private String nombre;
    private int size;
    private String abr;
    private String capital;
    private Clima clima = new Clima();

    public Provincia(String nombre, int size, String abr, String capital) throws SQLException,IOException
    {
        this.nombre = nombre;
        this.size = size;
        this.abr = abr;
        this.capital = capital;
        System.out.print("Provincia "+ nombre+" Guardada\n");
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void nuevoDia(float temp, String descr, Date fecha, int nomSemana)
    {
        clima.nuevoDia(temp,descr,fecha,nomSemana);
    }
    public void setViento (int velV,String dir)
    {
        clima.setViento(velV,dir);
    }
    public  void  setAtmosfera (float pre,int hum, int ambAs,int vis)
    {
        clima.setAtmosfera(pre,hum,ambAs,vis);
    }
    public void diaSig (int max, int min,Date fecha, String descripcion)
    {
        clima.diaSig(max,min,fecha,descripcion);
    }
}
