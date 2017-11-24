package com.principal;


import java.util.Date;

public class Clima {
    private Pronostico pronostico=new Pronostico();
    private Atmosfera atmosfera=new Atmosfera();
    private Viento viento=new Viento();

    public void nuevoDia(float temp, String descr, java.sql.Date fecha, int nomSemana)
    {
        pronostico.nuevoDia(temp,descr,fecha,nomSemana);
    }

    public void setViento(int velV,String dir) {
        viento.setDireccion(dir);
        viento.setVelocidad(velV);
        System.out.println("Viento guardado");
    }
    public void setAtmosfera(float pre,int hum, int ambAs,int vis) {
        atmosfera.setPresion(pre);
        atmosfera.setHumedad(hum);
        atmosfera.setAmbienteAscendente(ambAs);
        atmosfera.setVisivilidad(vis);
        System.out.println("Atmosfera guardada");

    }
    public void diaSig (int max, int min, java.sql.Date fecha, String descripcion)
    {
        pronostico.diaSig(max,min,fecha,descripcion);
    }

}
