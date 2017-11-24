package DAO;

public interface SuperDAO <o,pk>
{
    void agregar(o primary);
    void eliminar(o primary);
    void modificar(o primary);
    o obtener (pk primary);
}
