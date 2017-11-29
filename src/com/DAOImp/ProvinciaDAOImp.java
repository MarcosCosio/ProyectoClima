package com.DAOImp;

import com.connection.Conexion;
import com.connection.ConsultaSQL;
import com.DAO.ProvinciaDAO;
import com.principal.Estado;
import com.principal.Provincia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinciaDAOImp implements ProvinciaDAO {
    private Conexion conexion=new Conexion();
    private ConsultaSQL cons=new ConsultaSQL();
    @Override
    public void agregar(Provincia primary) {
        conexion.conectar();
        String [] datos = new String[]{primary.getNombre(), primary.getAbr(), String.valueOf(primary.getSize()),primary.getCapital(),String.valueOf(primary.getEstado().getPaisCod())};
        conexion.actualizar(this.cons.hacerInsert("provincia",datos));
        conexion.desconectar();
    }

    @Override
    public void eliminar(Provincia primary) {
        conexion.conectar();
        String[] where=new String[]{"Abr="+primary.getAbr()};
        conexion.actualizar(cons.hacerDelete("localidad",where));
        conexion.desconectar();
    }

    @Override
    public void modificar(Provincia old, Provincia nuevo) throws SQLException {
        conexion.conectar();
        String[] dataUP=new String[]{"nombre="+nuevo.getNombre(),"Abr="+nuevo.getAbr(),"size="+nuevo.getSize(),"capital="+String.valueOf(nuevo.getCapital()),
                "paisCod"+nuevo.getEstado().getPaisCod()};
        String[] where=new String[]{"Abr="+old.getAbr()};
        cons.hacerUpdate("provincia",dataUP,where);
        conexion.desconectar();
    }

    @Override
    public Provincia obtener(String abr) throws SQLException {
        conexion.conectar();
        String []where=new String[]{"abr="+abr};
        ResultSet rs=conexion.consultar(cons.select("Provincia",null,where));
        EstadoDAOImp estI=new EstadoDAOImp();
        Estado est=estI.obtener(rs.getInt(5));
        Provincia e=new Provincia(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),est);
        conexion.desconectar();
        return e;
    }
}
