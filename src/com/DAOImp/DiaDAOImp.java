package com.DAOImp;

import com.connection.Conexion;
import com.connection.ConsultaSQL;
import com.DAO.DiaDAO;
import com.principal.Dia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DiaDAOImp implements DiaDAO{

    private Conexion conexion=new Conexion();
    private ConsultaSQL cons=new ConsultaSQL();

    @Override
    public void agregar(Dia primary) {
        conexion.conectar();
        String [] datos = new String[]{String.valueOf(primary.getFecha()),  String.valueOf(primary.getMax()), String.valueOf(primary.getMin())
                ,primary.getDescripcion(),String.valueOf(primary.getTemperatura()),primary.getDiaSemana()};
        conexion.actualizar(this.cons.hacerInsert("dia",datos));
        conexion.desconectar();
    }

    @Override
    public void eliminar(Dia primary) {
        conexion.conectar();
        String[] where=new String[]{"fecha="+String.valueOf(primary.getFecha())};
        conexion.actualizar(cons.hacerDelete("dia",where));
        conexion.desconectar();
    }

    @Override
    public void modificar(Dia old, Dia nuevo) throws SQLException {
        conexion.conectar();
        String[] dataUP=new String[]{"fecha="+nuevo.getFecha(),"max="+nuevo.getMax(),"min="+nuevo.getMin(),
                "descripcion="+nuevo.getDescripcion(),"temperatura="+nuevo.getTemperatura()};
        String[] where=new String[]{"fecha="+String.valueOf(old.getFecha())};
        cons.hacerUpdate("dia",dataUP,where);
        conexion.desconectar();
    }

    @Override
    public Dia obtener(LocalDateTime primary) throws SQLException {
        conexion.conectar();
        String []where=new String[]{"fecha="+primary};
        ResultSet rs=conexion.consultar(cons.select("dia",null,where));
        Dia e=new Dia(rs.getFloat(5),rs.getString(4),primary,rs.getString(6));
        conexion.desconectar();
        return e;
    }
}
