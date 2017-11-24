package DAOImp;

import Connection.ConsultaSQL;
import DAO.EstadoDAO;
import Connection.Conexion;
import com.principal.Estado;


public class EstadoDAOImp implements EstadoDAO{

    private Conexion conexion=new Conexion();
    private ConsultaSQL cons=new ConsultaSQL();




    @Override
    public void agregar(Estado primary) {
    conexion.conectar();
    String [] datos = new String[]{primary.getNom(),primary.getLettCod2(), primary.getLettCod3(), String.valueOf(primary.getPaisCod())};
    conexion.actualizar(this.cons.hacerInsert("estado",datos));
    conexion.desconectar();
    }

    @Override
    public void eliminar(Estado primary) {

    }

    @Override
    public void modificar(Estado primary) {

    }

    @Override
    public Estado obtener(Integer primary) {
        return null;
    }


}
