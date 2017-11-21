package com.principal;

import java.util.Date;

public class Dia {

    private float temperatura;
    private String descripcion;
    private String diaSemana;
    private int max;
    private int min;
    private java.util.Date fecha;

    public Dia(float temperatura, String descripcion, Date fecha, String diaSemana) {
        this.temperatura = temperatura;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.diaSemana = diaSemana;
    }

    public Dia(int max, int min,Date fecha, String descripcion, String diaSemana) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
