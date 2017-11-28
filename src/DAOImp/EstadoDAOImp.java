package DAOImp;

import Connection.ConsultaSQL;
import DAO.EstadoDAO;
import Connection.Conexion;
import com.principal.Estado;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EstadoDAOImp implements EstadoDAO {

    private Conexion conexion=new Conexion();
    private ConsultaSQL cons=new ConsultaSQL();





    @Override
    public void agregar(Estado primary) {
    conexion.conectar();
    String [] datos = new String[]{String.valueOf(primary.getNom()),String.valueOf(primary.getLettCod2()) ,String.valueOf(primary.getLettCod3()), String.valueOf(primary.getPaisCod())};
    conexion.actualizar(this.cons.hacerInsert("estado",datos));
    conexion.desconectar();
    }

    @Override
    public void eliminar(Estado primary) {
        conexion.conectar();
        String[] where=new String[]{"paisCod="+String.valueOf(primary.getPaisCod())};
        conexion.actualizar(cons.hacerDelete("estado",where));
        conexion.desconectar();
    }

    @Override
    public void modificar(Estado old,Estado nuevo) throws SQLException{
        conexion.conectar();
        String[] dataUP=new String[]{"nombre="+nuevo.getNom(),"lettCod2="+nuevo.getLettCod2(),"lettCod3="+nuevo.getLettCod3(),"paisCod="+String.valueOf(nuevo.getPaisCod())};
        String[] where=new String[]{"paiscod="+String.valueOf(old.getPaisCod())};
        cons.hacerUpdate("estado",dataUP,where);
        conexion.desconectar();
    }

    @Override
    public Estado obtener(Integer primary) throws SQLException {
        conexion.conectar();
        String []where=new String[]{"paisCod="+String.valueOf(primary)};
        ResultSet rs=conexion.consultar(cons.select("estado",null,where));
        Estado e=new Estado(rs.getString(1),rs.getString(2),rs.getString(3),primary);
        conexion.desconectar();
        return e;
    }


}
