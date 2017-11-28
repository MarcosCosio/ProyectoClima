package DAO;

        import com.principal.Clima;

        import java.sql.Date;
        import java.sql.SQLException;
        import java.time.LocalDateTime;

public interface ClimaDAO
        {
            void agregar(Clima primary);
            void eliminar(Clima primary);
            void modificar(Clima old, Clima nuevo) throws SQLException;
            Clima obtener(LocalDateTime fecha, int idLocalidad) throws SQLException;
        }
