package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.InformacionRegistro;

public interface InformacionRegistroRepository {
    @Query(value = "SELECT * FROM informacion_registros", nativeQuery = true)
    Collection<InformacionRegistro> darInformacionRegistros();

      @Query(value = "SELECT * FROM informacion_registros WHERE id = :id", nativeQuery = true)
    InformacionRegistro darInformacionRegistro(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM informacion_registros WHERE id = :id", nativeQuery = true)
    void eliminarInformacionRegistro(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE informacion_registro SET dia_entrada = :diaEntrada, mes_entrada = :mesEntrada, " +
            "anio_entrada = :anioEntrada, dia_salida = :diaSalida, mes_salida = :mesSalida, anio_salida = :anioSalida, " +
            "id_usuario = :idUsuario, id_habitacion = :idHabitacion WHERE id = :id", nativeQuery = true)
    void actualizarInformacionRegistro(@Param("id") int id, @Param("diaEntrada") Integer diaEntrada, @Param("mesEntrada") Integer mesEntrada,
                                       @Param("anioEntrada") Integer anioEntrada, @Param("diaSalida") Integer diaSalida,
                                       @Param("mesSalida") Integer mesSalida, @Param("anioSalida") Integer anioSalida,
                                       @Param("idUsuario") Integer idUsuario, @Param("idHabitacion") Integer idHabitacion);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO informacion_registro (id, dia_entrada, mes_entrada, anio_entrada, dia_salida, mes_salida, anio_salida, id_usuario, id_habitacion) " +
    "VALUES (hoteles_sequence.nextval, :diaEntrada, :mesEntrada, :anioEntrada, :diaSalida, :mesSalida, :anioSalida, :idUsuario, :idHabitacion)", nativeQuery = true)
    void insertarInformacionRegistro(@Param("diaEntrada") Integer diaEntrada, @Param("mesEntrada") Integer mesEntrada,
    @Param("anioEntrada") Integer anioEntrada, @Param("diaSalida") Integer diaSalida,
    @Param("mesSalida") Integer mesSalida, @Param("anioSalida") Integer anioSalida,
    @Param("idUsuario") Integer idUsuario, @Param("idHabitacion") Integer idHabitacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO informacion_registro (id, dia_entrada, mes_entrada, anio_entrada, dia_salida, mes_salida, anio_salida, id_usuario, id_habitacion) " +
    "VALUES (hoteles_sequence.nextval, :diaEntrada, :mesEntrada, :anioEntrada, NULL, NULL, NULL, :idUsuario, :idHabitacion)", nativeQuery = true)
    void insertarInformacionRegistroEntrada(@Param("diaEntrada") Integer diaEntrada, @Param("mesEntrada") Integer mesEntrada,
    @Param("anioEntrada") Integer anioEntrada, @Param("idUsuario") Integer idUsuario,
    @Param("idHabitacion") Integer idHabitacion);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO informacion_registro (id, dia_entrada, mes_entrada, anio_entrada, dia_salida, mes_salida, anio_salida, id_usuario, id_habitacion) " +
    "VALUES (hoteles_sequence.nextval, NULL, NULL, NULL, :diaSalida, :mesSalida, :anioSalida, :idUsuario, :idHabitacion)", nativeQuery = true)
    void insertarInformacionRegistroSalida(@Param("diaSalida") Integer diaSalida, @Param("mesSalida") Integer mesSalida,
    @Param("anioSalida") Integer anioSalida, @Param("idUsuario") Integer idUsuario,
    @Param("idHabitacion") Integer idHabitacion);
                                       
    
}
