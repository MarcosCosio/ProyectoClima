package com.principal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Consola
{
    //El objetivo de consola es el tratamiento de datos por consola (tanto entrada como salida), asi como procesamiento de strings
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Consola cons=null;

    public Consola consola()
    {
        if (cons==null)
        {
            cons=new Consola();
        }

        return cons;
    }
    public int leerInt(String str) throws IOException
    {
        out(str);
        int datoInt=0;
        try {
            datoInt = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Formato Invalido");
        }
        return datoInt;
    }

    public float leerFloat (String str) throws  IOException
    {
        out(str);
        float datoFloat=0;
        try
        {
            datoFloat = Float.parseFloat(br.readLine());
        }
        catch (NumberFormatException nfe)
        {
            System.err.println("Formato Invalido");
        }
        return datoFloat;
    }

    public String leerLinea (String str) throws IOException
    {
        out(str);
        String linea= br.readLine();
        return linea;
    }

    public void out (String str)
    {
        System.out.println(str);
    }

    public Date getDateSQL (int anio,int mes,int dia) throws ParseException {
        String oldstring = anio+"-"+mes+"-"+dia;
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
        java.sql.Date dateS=new java.sql.Date(date.getTime());
        return  dateS;
    }
}
