package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface HabitacionRepository extends JpaRepository<Habitacion,Integer>{


    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE id =:id", nativeQuery = true)
    Habitacion darHabitacion(
        @Param("id") Integer id
    );

    @Modifying
    @Transactional
    @Query(value=
    "INSERT INTO"+
    "habitaciones(id,capacidad,precio_habitacion,precio_minibar,consumos_tienda,esta_ocupada,tipo)"+
    "values (hoteles_sequence.nextval,:capacidad,:precioHabitacion,:precioMinibar,:consumosTienda,:ocupada,:tipo)"
    ,nativeQuery=true)
    void insertarHabitacion(
        @Param("capacidad") Integer capacidad,
        @Param("precioHabitacion") Double precioHabitacion,
        @Param("precioMinibar") Double precioMinibar,
        @Param("consumosTienda") Double consumosTienda,
        @Param("ocupada") Integer estaOcupada,
        @Param("tipo") Integer tipo
    );

    @Modifying
    @Transactional
    @Query(value = 
        "UPDATE habitaciones SET" +
            "capacidad = :capacidad,"+
            "precio_habitacion =: precioHabitacion,"+
            "precio_minibar =: precioMinibar,"+
            "consumos_tienda =: consumosTienda," +
            "esta_ocupada =: ocupada," +
            "tipo =: tipo"+
        "WHERE id= :id"
        , nativeQuery = true)
    void actualizarHabitacion(
        @Param("id") Integer id,
        @Param("capacidad") Integer capacidad,
        @Param("precioHabitacion") Double precioHabitacion,
        @Param("precioMinibar") Double precioMinibar,
        @Param("consumosTienda") Double consumosTienda,
        @Param("ocupada") Integer estaOcupada,
        @Param("tipo") Integer tipo
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(
        @Param("id") Integer id
    );

}