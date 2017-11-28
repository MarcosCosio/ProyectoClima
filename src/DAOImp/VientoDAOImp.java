package DAOImp;

import Connection.Conexion;
import Connection.ConsultaSQL;
import DAO.VientoDAO;
import com.principal.Viento;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VientoDAOImp implements VientoDAO{

    private Conexion conexion=new Conexion();
    private ConsultaSQL cons=new ConsultaSQL();

    @Override
    public void agregar(Viento primary) {
        conexion.conectar();
        String [] datos = new String[]{String.valueOf(primary.getCodViento()),String.valueOf(primary.getVelocidad()), primary.getDireccion()};
        conexion.actualizar(this.cons.hacerInsert("viento",datos));
        conexion.desconectar();
    }

    @Override
    public void eliminar(Viento primary) {
        conexion.conectar();
        String[] where=new String[]{"idViento="+String.valueOf(primary.getCodViento())};
        conexion.actualizar(cons.hacerDelete("viento",where));
        conexion.desconectar();
    }

    @Override
    public void modificar(Viento old, Viento nuevo) throws SQLException {
        conexion.conectar();
        String[] dataUP=new String[]{"idViento="+nuevo.getCodViento(),"velViento="+nuevo.getVelocidad(),"direccion="+nuevo.getDireccion()};
        String[] where=new String[]{"idViento="+String.valueOf(old.getCodViento())};
        cons.hacerUpdate("viento",dataUP,where);
        conexion.desconectar();
    }

    @Override
    public Viento obtener(Integer primary) throws SQLException {
        conexion.conectar();
        String []where=new String[]{"idViento="+String.valueOf(primary)};
        ResultSet rs=conexion.consultar(cons.select("viento",null,where));
        Viento e=new Viento(rs.getInt(1),rs.getString(2),primary);
        conexion.desconectar();
        return e;
    }
}
