package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ReservaEspacio;

import java.util.Collection;

public interface ReservaEspacioRepository {

    @Query(value = "SELECT * FROM reservas_espacios", nativeQuery = true)
    Collection<ReservaEspacio> darReservasEspacios();

    @Query(value = "SELECT * FROM reservas_espacios WHERE id = :id", nativeQuery = true)
    ReservaEspacio darReservaEspacio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas_espacios WHERE id = :id", nativeQuery = true)
    void eliminarReservaEspacio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas_espacios SET espacio = :espacio, dia = :dia, mes = :mes, anio =:anio, hora = :hora WHERE id = :id", nativeQuery = true)
    void actualizarReservaEspacio(@Param("id") Integer id, @Param("espacio") Integer espacio,@Param("dia") Integer dia, @Param("mes") Integer mes, @Param("anio") Integer anio,
                                  @Param("hora") Integer hora);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas_espacios (id, espacio, dia, mes, anio, hora) VALUES (:id, :espacio, :dia, :mes, :anio, :hora)", nativeQuery = true)
    void insertarReservaEspacio(@Param("id") int id, @Param("espacio") Integer espacio,@Param("dia") Integer dia, @Param("mes") Integer mes, @Param("anio") Integer anio,
                                  @Param("hora") Integer hora);
}
