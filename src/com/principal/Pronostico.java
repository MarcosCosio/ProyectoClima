package com.principal;



import java.util.Date;


public class Pronostico {


    private int diaSig=0;
    private Dia [] pronExten=new Dia[10];
    private String[]nomSemana={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};


    public void nuevoDia(float temp, String descr, Date fecha,int nomSemana)
    {
        String diaSemana=this.getNomSemana(nomSemana);
        pronExten[0]=new Dia(temp,descr,fecha,diaSemana);
        System.out.println("Dia guardado");
        diaSig=1;
    }
    public void diaSig(int max, int min,Date fecha, String descripcion)
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
}
