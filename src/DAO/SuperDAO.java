package DAO;

import java.sql.SQLException;

public interface SuperDAO <o,y>
{
    void agregar(o primary);
    void eliminar(o primary);
    void modificar(o old,o nuevo) throws SQLException;
    o obtener (y primary) throws SQLException;
}
