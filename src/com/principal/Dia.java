package com.principal;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Dia {

    private float temperatura;
    private String descripcion;
    private String diaSemana;
    private int max;
    private int min;
    private LocalDateTime fecha;

    public Dia(float temperatura, String descripcion, LocalDateTime fecha, String diaSemana) {
        this.temperatura = temperatura;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.diaSemana = diaSemana;
    }

    public Dia(int max, int min, LocalDateTime fecha, String descripcion, String diaSemana) {
        this.max = max;
        this.min = min;
        this.fecha=fecha;
        this.descripcion=descripcion;
        this.diaSemana=diaSemana;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha (int anio,int mes,int dia,int hora,int min,int seg) throws ParseException {
        String oldstring = "\""+anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+seg+"\"";
        LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        this.fecha=datetime;

    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
