package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Servicios;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;

import java.util.Collection;

public interface ServicioRepository extends JpaRepository<Servicios, Integer> {

    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicios> darServicios();

    @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
    Servicios darServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET precio_unitario = :precio_unitario, id_hotel = :id_hotel WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") int id, @Param("precio_unitario") Integer precio_unitario, @Param("id_hotel") Integer id_hotel);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (id,precio_unitario,id_hotel) VALUES (hoteles_sequence.nextval,:precio_unitario,:id_hotel )", nativeQuery = true)
    void insertarServicio(@Param("id") int id, @Param("precio_unitario") Integer precio_unitario, @Param("id_hotel") Integer id_hotel);
}
