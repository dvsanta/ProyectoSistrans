package uniandes.edu.co.proyecto.repositorio;
import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Servicios;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface ConsumoRepository {
    @Query(value = "SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();

      @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") int id);

    @Modifying
@Transactional
@Query(value = "UPDATE consumos SET descripcion = :descripcion, precio_total = :precioTotal, dia = :dia, mes = :mes, anio = :anio, " +
        "id_servicio = :idServicio, id_habitacion = :idHabitacion WHERE id = :id", nativeQuery = true)
void actualizarConsumo(@Param("id") int id, @Param("descripcion") String descripcion,
                       @Param("precioTotal") double precioTotal, @Param("dia") Date dia,
                       @Param("mes") Date mes, @Param("anio") Date anio,
                       @Param("idServicio") Servicios idServicio, @Param("idHabitacion") Habitacion idHabitacion);

@Modifying
@Transactional
@Query(value = "INSERT INTO consumos (descripcion, precio_total, dia, mes, anio, id_servicio, id_habitacion) " +
        "VALUES (:descripcion, :precioTotal, :dia, :mes, :anio, :idServicio, :idHabitacion)", nativeQuery = true)
void insertarConsumo(@Param("descripcion") String descripcion, @Param("precioTotal") double precioTotal,
                     @Param("dia") Date dia, @Param("mes") Date mes, @Param("anio") Date anio,
                     @Param("idServicio") Servicios idServicio, @Param("idHabitacion") Habitacion idHabitacion);

}
