package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion,Integer>{


    @Query(value = "SELECT * FROM tipo_habitaciones", nativeQuery=true)  
    Collection<TipoHabitacion> darTiposHabitaciones();


    @Query(value = "SELECT * FROM tipo_habitaciones WHERE id =:id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value=
    "INSERT INTO tipo_habitaciones(id,nombre)"+
    "VALUES (hoteles_sequence.nextval,:nombre)"
    ,nativeQuery=true)
    void insertarTipoHabitacion(@Param("nombre") String nombre);

    @Transactional
    @Modifying
    @Query(value=
    "UPDATE tipo_habitaciones SET nombre = :nombre"+
    "WHERE id = :id"
    ,nativeQuery=true)
    void actualizarTipoHabitacion(
        @Param("id") Integer id, 
        @Param("nombre") String nombre);


    @Transactional
    @Modifying
    @Query(value="DELETE FROM tipo_habitaciones WHERE id =:id"
    ,nativeQuery=true)
    void eliminarTipoHabitacion(@Param("id") Integer id);


}