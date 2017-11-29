package com.DAOImp;

import com.connection.Conexion;
import com.connection.ConsultaSQL;
import com.DAO.ClimaDAO;
import com.principal.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ClimaDAOImp  implements ClimaDAO
{
    private Conexion conexion=new Conexion();
    private ConsultaSQL cons=new ConsultaSQL();

    @Override
    public void agregar(Clima primary) {
        conexion.conectar();
        String [] datos = new String[]{String.valueOf(primary.get1erDia().getFecha()),String.valueOf(primary.getAtmosfera().getCodAtm()),String.valueOf(primary.getViento().getCodViento()),
                String.valueOf(primary.getLocalidad().getCodLoc())};
        conexion.actualizar(this.cons.hacerInsert("clima",datos));
        conexion.desconectar();
    }

    @Override
    public void eliminar(Clima primary) {
        conexion.conectar();
        String[] where=new String[]{"fecha="+String.valueOf(primary.get1erDia().getFecha()),"idLocalidad="+primary.getLocalidad().getCodLoc()};
        conexion.actualizar(cons.hacerDelete("clima",where));
        conexion.desconectar();
    }

    @Override
    public void modificar(Clima old, Clima nuevo) throws SQLException {
        conexion.conectar();
        String[] dataUP=new String[]{"fecha="+String.valueOf(nuevo.get1erDia().getFecha()),"idAtmosfera="+nuevo.getAtmosfera().getCodAtm(),"idViento="+nuevo.getViento().getCodViento(),
                "idLocalidad="+nuevo.getLocalidad().getCodLoc()};
        String[] where=new String[]{"fecha="+String.valueOf(old.get1erDia().getFecha()),"idLocalidad="+old.getLocalidad().getCodLoc()};
        cons.hacerUpdate("clima",dataUP,where);
        conexion.desconectar();
    }

    @Override
    public Clima obtener(LocalDateTime fecha,int idLocalidad) throws SQLException {
        conexion.conectar();
        String[] where = new String[]{"fecha=" + fecha, "idLocalidad=" + String.valueOf(idLocalidad)};
        ResultSet rs = conexion.consultar(cons.select("clima", null, where));
        DiaDAOImp diaI = new DiaDAOImp();
        Dia dia= diaI.obtener(fecha);
        AtmosferaDAOImp atm = new AtmosferaDAOImp();
        Atmosfera at=atm.obtener(rs.getInt(2));
        VientoDAOImp vien= new VientoDAOImp();
        Viento v=vien.obtener(rs.getInt(3));
        LocalidadDAOImp locI=new LocalidadDAOImp();
        Localidad loc = locI.obtener(rs.getInt(4));
        Clima e=new Clima(dia,at,v,loc);
        conexion.desconectar();
        return e;
        }
}
