package com.principal;


import java.sql.Date;
import java.time.LocalDateTime;

public class Pronostico {


    private int diaSig=0;
    private Dia [] pronExten=new Dia[10];
    private String[]nomSemana={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};


    public void nuevoDia(float temp, String descr, LocalDateTime fecha, int nomSemana)
    {
        String diaSemana=this.getNomSemana(nomSemana);
        pronExten[0]=new Dia(temp,descr,fecha,diaSemana);
        System.out.println("Dia guardado");
        diaSig=1;
    }
    public void diaSig(int max, int min, LocalDateTime fecha, String descripcion)
    {
        String diaSemana;
        if (diaSig<nomSemana.length)
        {
            diaSemana=this.getNomSemana(diaSig);
            diaSig++;
        }
        else
        {
            diaSemana=this.getNomSemana(0);
            diaSig=0;
        }
        if (diaSig<pronExten.length)
        {
            pronExten[diaSig] = new Dia(max, min, fecha, descripcion,diaSemana);
            System.out.println("Dia guardado");
            diaSig++;
        }
        else
            {
                System.out.println("Ya estan los 10 dias");
            }

    }

    public String getNomSemana(int numS) {
        String nS=nomSemana[numS];
        return nS;
    }
    public void set1erDia(Dia dia)
    {
        pronExten[0]= dia;
    }
    public Dia get1erdia ()
    {
        Dia primero= pronExten[0];
        return primero;
    }
}
