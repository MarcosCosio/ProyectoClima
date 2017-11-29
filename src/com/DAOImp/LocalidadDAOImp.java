package com.DAOImp;

import com.connection.Conexion;
import com.connection.ConsultaSQL;
import com.DAO.LocalidadDAO;
import com.principal.Localidad;
import com.principal.Provincia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalidadDAOImp implements LocalidadDAO{



    private Conexion conexion=new Conexion();
    private ConsultaSQL cons=new ConsultaSQL();
    @Override
    public void agregar(Localidad primary) {
        conexion.conectar();
        String [] datos = new String[]{String.valueOf(primary.getCodLoc()), primary.getNombre(), primary.getProv().getAbr()
                ,primary.getAbr()};
        conexion.actualizar(this.cons.hacerInsert("localidad",datos));
        conexion.desconectar();
    }

    @Override
    public void eliminar(Localidad primary) {
        conexion.conectar();
        String[] where=new String[]{"id_Localidad="+String.valueOf(primary.getCodLoc())};
        conexion.actualizar(cons.hacerDelete("localidad",where));
        conexion.desconectar();
    }

    @Override
    public void modificar(Localidad old, Localidad nuevo) throws SQLException {
        conexion.conectar();
        String[] dataUP=new String[]{"id_Localidad="+nuevo.getCodLoc(),"nombre="+nuevo.getNombre(),"Abr="+nuevo.getProv().getAbr(),"AbrLoc="+String.valueOf(nuevo.getAbr())};
        String[] where=new String[]{"id_Localidad="+String.valueOf(old.getCodLoc())};
        cons.hacerUpdate("localidad",dataUP,where);
        conexion.desconectar();
    }

    @Override
    public Localidad obtener(Integer primary) throws SQLException {
        conexion.conectar();
        String []where=new String[]{"idLocalidad="+String.valueOf(primary)};
        ResultSet rs=conexion.consultar(cons.select("localidad",null,where));
        ProvinciaDAOImp provI=new ProvinciaDAOImp();
        Provincia prov =provI.obtener(rs.getString(3));
        Localidad e=new Localidad(rs.getString(2),rs.getString(4),primary,prov);
        conexion.desconectar();
        return e;
    }
}
