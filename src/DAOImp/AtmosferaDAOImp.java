package DAOImp;

import Connection.Conexion;
import Connection.ConsultaSQL;
import DAO.AtmosferaDAO;
import com.principal.Atmosfera;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AtmosferaDAOImp implements AtmosferaDAO {


    private Conexion conexion=new Conexion();
    private ConsultaSQL cons=new ConsultaSQL();
    @Override
    public void agregar(Atmosfera primary) {
        conexion.conectar();
        String [] datos = new String[]{String.valueOf(primary.getHumedad()),String.valueOf(primary.getPresion()), String.valueOf(primary.getAmbienteAscendente()),
                String.valueOf(primary.getVisivilidad()),String.valueOf(primary.getCodAtm())};
        conexion.actualizar(this.cons.hacerInsert("atmosfera",datos));
        conexion.desconectar();
    }

    @Override
    public void eliminar(Atmosfera primary) {
        conexion.conectar();
        String[] where=new String[]{"idAtmosfera="+String.valueOf(primary.getCodAtm())};
        conexion.actualizar(cons.hacerDelete("atmosfera",where));
        conexion.desconectar();
    }

    @Override
    public void modificar(Atmosfera old, Atmosfera nuevo) throws SQLException {
        conexion.conectar();
        String[] dataUP=new String[]{"humedad="+nuevo.getHumedad(),"presion="+nuevo.getPresion(),"ambienteAscendente="+nuevo.getAmbienteAscendente(),
                "visibilidad="+nuevo.getVisivilidad(),"idAtmosfera="+nuevo.getCodAtm()};
        String[] where=new String[]{"idAtmosfera="+String.valueOf(old.getCodAtm())};
        cons.hacerUpdate("atmosfera",dataUP,where);
        conexion.desconectar();
    }

    @Override
    public Atmosfera obtener(Integer primary) throws SQLException {
        conexion.conectar();
        String []where=new String[]{"idAtmosfera="+String.valueOf(primary)};
        ResultSet rs=conexion.consultar(cons.select("atmosfera",null,where));
        Atmosfera e=new Atmosfera(rs.getInt(1),rs.getFloat(2),rs.getInt(4),rs.getInt(3),primary);
        conexion.desconectar();
        return e;
    }
}
