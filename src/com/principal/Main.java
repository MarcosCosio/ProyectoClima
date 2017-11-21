package com.principal;

import com.principal.Connection.BD;


import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.text.SimpleDateFormat;


public class Main {



    public static void main(String[] args) throws SQLException,IOException,ParseException
    {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BD database = new BD();
        Estado estActual=null;
        Provincia provActual=null;
        ArrayList<Estado> estados = new ArrayList<>();
        int opc=99;
        int diaActual=0;
        int mesActual=0;
        int anioActual=0;


        do {
            System.out.print("Por Favor ingrese opcion\n" +
                    "1 Nuevo Estados\n" +
                    "2 Nueva Provincia\n" +
                    "3 Guardar Dia Actual\n" +
                    "4 Guardar Viento\n" +
                    "5 Guardar Armosfera\n" +
                    "6 Guardar Dia Siguiente\n" +
                    "7 Salir\n");


            try {
                opc = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Formato Invalido");
            }
            switch (opc)
            {
                //1
                case 1:
                {
                    System.out.println("Ingrese Nombre");
                    String nom= br.readLine();
                    System.out.println("Ingrese Codigo Pais (2 letras)");
                    String lettcod2=br.readLine();
                    System.out.println("Ingrese Codigo Pais (3 letras)");
                    String lettcod3=br.readLine();
                    Estado est= new Estado(nom,lettcod2,lettcod3);
                    estados.add(est);

                }
                break;
                case 2:
                {

                    System.out.println("Ingrese a que estado pertenece la provincia");
                    String est=br.readLine();
                    for(int i=0;i<estados.size();i++)
                    {
                        if (est.equals(estados.get(i).getNom())) {
                        estActual=estados.get(i);
                       }
                    }
                    System.out.println("Ingrese Nombre");
                    String nom= br.readLine();
                    System.out.println("Ingrese Tamaño de la Provincia");
                    int size=Integer.parseInt(br.readLine());
                    System.out.println("Ingresar abreviatura de provincia");
                    String abr=br.readLine();
                    System.out.println("Ingresar capital de provincia");
                    String cap=br.readLine();
                    Provincia prov= new Provincia(nom,size,abr,cap);
                    estActual.setProv(prov);
                    provActual=prov;

                }
                break;
                case 3:
                {
                    System.out.println("Ingrese Dia");
                    int dia=Integer.parseInt(br.readLine());
                    diaActual=dia;
                    System.out.println("Ingrese Mes");
                    int mes=Integer.parseInt(br.readLine());
                    mesActual=mes;
                    System.out.println("Ingresar Año");
                    int anio=Integer.parseInt(br.readLine());
                    anioActual=anio;
                    String oldstring = anio+"-"+mes+"-"+dia;
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
                    System.out.println("Ingrese Temperatura Actual");
                    float temp=Float.parseFloat(br.readLine());
                    System.out.println("Ingresar Descripcion");
                    String descr=br.readLine();
                    System.out.println("Ingrese Dia de la Semana(1 para Lunes,2 para Martes,etc)");
                    int nomSemana=Integer.parseInt(br.readLine());
                    provActual.nuevoDia(temp,descr,date,nomSemana);
                }
                break;
                case 4:
                {
                    System.out.println("Ingresar Velocidad");
                    int velV=Integer.parseInt(br.readLine());
                    System.out.println("Ingresar Direccion");
                    String dir=br.readLine();
                    provActual.setViento(velV,dir);
                }
                break;
                case 5:
                {
                    System.out.println("Ingresar Presion");
                    float pre=Float.parseFloat(br.readLine());
                    System.out.println("Ingresar Humedad");
                    int hum=Integer.parseInt(br.readLine());
                    System.out.println("Ingresar visibilidad");
                    int vis=Integer.parseInt(br.readLine());
                    System.out.println("Ingresar Ambiente Ascendente");
                    int ambAs=Integer.parseInt(br.readLine());
                    provActual.setAtmosfera(pre,hum,ambAs,vis);
                }
                break;
                case 6:
                {

                    diaActual++;
                    String oldstring = anioActual+"-"+mesActual+"-"+diaActual;
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
                    System.out.println("Ingrese Maxima Pronosticada");
                    int max=Integer.parseInt(br.readLine());
                    System.out.println("Ingrese Minima Pronosticada");
                    int min=Integer.parseInt(br.readLine());
                    System.out.println("Ingresar Descripcion");
                    String descr=br.readLine();
                    provActual.diaSig(max,min,date,descr);
                }

            }

        }
        while (opc!=7);

    }

}

