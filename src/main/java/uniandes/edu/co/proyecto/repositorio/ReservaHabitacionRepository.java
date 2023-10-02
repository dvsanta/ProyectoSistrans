package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.ReservaHabitacion;

import java.util.Collection;

public interface ReservaHabitacionRepository extends JpaRepository<ReservaHabitacion, Integer> {

    @Query(value = "SELECT * FROM resevas_habitaciones", nativeQuery = true)
    Collection<ReservaHabitacion> darReservasHabitaciones();

    @Query(value = "SELECT * FROM resevas_habitaciones WHERE id = :id", nativeQuery = true)
    ReservaHabitacion darReservaHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM resevas_habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarReservaAplicacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE resevas_habitaciones SET num_personas = :num_personas, tipo_plan = :tipo_plan, dia_entrada = :dia_entrada, mes_entrada = :mes_entrada, " + //
            " anio_entrada = :anio_entrada, dia_salida = :dia_salida, mes_salida = :mes_salida, anio_salida = :anio_salida," +//
            "id_usuario = :id_usuario, id_habitacion = :id_habitacion WHERE id = :id", nativeQuery = true)
    void actualizarReservaHabitacion(@Param("id") int id, @Param("num_personas") Integer num_personas, @Param("tipo_plan") Integer tipo_plan,
                               @Param("dia_entrada") Integer dia_entrada, @Param("mes_entrada") Integer mes_entrada, @Param("anio_entrada") Integer anio_entrada,
                                     @Param("dia_salida") Integer dia_salida,@Param("mes_salida") Integer mes_salida, @Param("anio_salida") Integer anio_salida,
                                     @Param("id_usuario") Integer id_usuario, @Param("id_habitacion") Integer id_habitacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO resevas_habitaciones (id,num_personas, tipo_plan, dia_entrada, mes_entrada, " + //
            " anio_entrada, dia_salida, mes_salida, anio_salida,id_usuario, id_habitacion) VALUES (hoteles_sequence.nextval, :num_personas, :tipo_plan, :dia_entrada," +
            ":mes_entrada, :anio_entrada, :dia_salida, :mes_salida, :anio_salida, :id_usuario, :id_habitacion)", nativeQuery = true)
    void insertarReservaHabitacion(@Param("num_personas") Integer num_personas, @Param("tipo_plan") Integer tipo_plan,
                                     @Param("dia_entrada") Integer dia_entrada, @Param("mes_entrada") Integer mes_entrada, @Param("anio_entrada") Integer anio_entrada,
                                     @Param("dia_salida") Integer dia_salida,@Param("mes_salida") Integer mes_salida, @Param("anio_salida") Integer anio_salida,
                                     @Param("id_usuario") Integer id_usuario, @Param("id_habitacion") Integer id_habitacion);
}
