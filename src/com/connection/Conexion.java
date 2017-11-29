package com.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion conexionBase;
    private java.sql.Connection conexion;
    private java.sql.ResultSet rs;



    public java.sql.ResultSet consultar(String query)
    {
        try
        {

            java.sql.Statement ste = conexion.createStatement();
            rs = ste.executeQuery(query);


        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.print("Error de Conexion");
        }
        finally {
            return rs;
        }
    }
    public void conectar()
    {
        try
        {

            conexion= DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");
            this.consultar("USE Clima");
            System.out.print("Conexion Establecida\n");

        }
        catch (SQLException e)
        {
            System.out.print("Error de conexion");
            e.printStackTrace();

        }
    }

    public void desconectar()
    {
        try
        {
            conexion.close();
            System.out.print("Conexion Terminada\n" + "\n");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void actualizar(String query)
    {
        try
        {

            java.sql.Statement ste = conexion.createStatement();
            ste.executeUpdate(query);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.print("Error de Conexion");
        }

    }

    public Conexion BD()
    {
        if (conexionBase==null) {
            conexionBase=new Conexion();
        }
        return conexionBase;
    }

}
