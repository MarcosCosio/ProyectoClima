package com.principal;

public class Viento {
    private int velocidad;
    private String direccion;
    private int codViento;

    public Viento(int velocidad, String direccion, int codViento) {
        this.velocidad = velocidad;
        this.direccion = direccion;
        this.codViento = codViento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getCodViento() {
        return codViento;
    }

    public void setCodViento(int codViento) {
        this.codViento = codViento;
    }

}
