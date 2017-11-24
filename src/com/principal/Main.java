package com.principal;

import DAOImp.EstadoDAOImp;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.io.IOException;





public class Main {



    public static void main(String[] args) throws SQLException,IOException,ParseException
    {



        Estado estActual=null;
        Provincia provActual=null;
        ArrayList<Estado> estados = new ArrayList<Estado>();
        Consola consola=new Consola();
        int opc=99;
        int diaActual=0;
        int mesActual=0;
        int anioActual=0;


        do {
            consola.out("Por Favor ingrese opcion\n" +
                    "1 Nuevo Estados\n" +
                    "2 Nueva Provincia\n" +
                    "3 Guardar Dia Actual\n" +
                    "4 Guardar Viento\n" +
                    "5 Guardar Armosfera\n" +
                    "6 Guardar Dia Siguiente\n" +
                    "7 Salir\n");


            opc=consola.leerInt("");
            switch (opc)
            {
                //1
                case 1:
                {
                    String nom= consola.leerLinea("Ingrese Nombre");
                    String lettcod2=consola.leerLinea("Ingrese Codigo Pais (2 letras)");
                    String lettcod3=consola.leerLinea("Ingrese Codigo Pais (3 letras)");
                    int paisCod=consola.leerInt("Ingrese Codigo numerico de pais");
                    Estado est= new Estado(nom,lettcod2,lettcod3,paisCod);
                    estados.add(est);
                    EstadoDAOImp estDAO =new EstadoDAOImp();
                    estDAO.agregar(est);

                }
                break;
                case 2:
                {

                    String est=consola.leerLinea("Ingrese a que estado pertenece la provincia");
                    for(int i=0;i<estados.size();i++)
                    {
                        if (est.equals(estados.get(i).getNom())) {
                        estActual=estados.get(i);
                       }
                    }
                    String nom= consola.leerLinea("Ingrese Nombre");
                    int size=consola.leerInt("Ingrese Tamaño de la Provincia");
                    String abr=consola.leerLinea("Ingresar abreviatura de provincia");
                    String cap=consola.leerLinea("Ingresar capital de provincia");
                    Provincia prov= new Provincia(nom,size,abr,cap);
                    estActual.setProv(prov);
                    provActual=prov;

                }
                break;
                case 3:
                {
                    int dia=consola.leerInt("Ingrese Dia");
                    diaActual=dia;
                    int mes=consola.leerInt("Ingrese Mes");
                    mesActual=mes;
                    int anio=consola.leerInt("Ingresar Año");
                    anioActual=anio;
                    java.sql.Date dateS=consola.getDateSQL(anio,mes,dia);
                    float temp=consola.leerFloat("Ingrese Temperatura Actual");
                    String descr=consola.leerLinea("Ingresar Descripcion");
                    int nomSemana=0;
                    do
                    {
                        nomSemana = consola.leerInt("Ingrese Dia de la Semana(1 para Lunes,2 para Martes,etc)");
                    }
                    while(!(nomSemana>0&&nomSemana<8));
                    provActual.nuevoDia(temp,descr,dateS,nomSemana);
                }
                break;
                case 4:
                {
                    int velV=consola.leerInt("Ingresar Velocidad");
                    String dir=consola.leerLinea("Ingresar Direccion");
                    provActual.setViento(velV,dir);
                }
                break;
                case 5:
                {
                    float pre=consola.leerFloat("Ingresar Presion");
                    int hum=consola.leerInt("Ingresar Humedad");
                    int vis=consola.leerInt("Ingresar visibilidad");
                    int ambAs=consola.leerInt("Ingresar Ambiente Ascendente");
                    provActual.setAtmosfera(pre,hum,ambAs,vis);
                }
                break;
                case 6:
                {

                    diaActual++;
                    java.sql.Date date = consola.getDateSQL(anioActual,mesActual,diaActual);
                    int max=consola.leerInt("Ingrese Maxima Pronosticada");
                    int min=consola.leerInt("Ingrese Minima Pronosticada");
                    String descr=consola.leerLinea("Ingresar Descripcion");
                    provActual.diaSig(max,min,date,descr);
                }

            }

        }
        while (opc!=7);

    }

}

