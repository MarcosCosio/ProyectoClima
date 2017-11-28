package com.principal;

public class Atmosfera {
    private int humedad;
    private float presion;
    private int visivilidad;
    private int ambienteAscendente;
    private int codAtm;

    public Atmosfera(int humedad, float presion, int visivilidad, int ambienteAscendente, int codAtm) {
        this.humedad = humedad;
        this.presion = presion;
        this.visivilidad = visivilidad;
        this.ambienteAscendente = ambienteAscendente;
        this.codAtm = codAtm;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public float getPresion() {
        return presion;
    }

    public void setPresion(float presion) {
        this.presion = presion;
    }

    public int getVisivilidad() {
        return visivilidad;
    }

    public void setVisivilidad(int visivilidad) {
        this.visivilidad = visivilidad;
    }

    public int getAmbienteAscendente() {
        return ambienteAscendente;
    }

    public void setAmbienteAscendente(int ambienteAscendente) {
        this.ambienteAscendente = ambienteAscendente;
    }

    public int getCodAtm() {
        return codAtm;
    }

    public void setCodAtm(int codAtm) {
        this.codAtm = codAtm;
    }

}
