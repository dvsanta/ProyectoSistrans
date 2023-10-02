package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository {
        @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

      @Query(value = "SELECT * FROM planes_consumo WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre = :nombre, correo_electronico = :correoElectronico, tipo = :tipo, id_hotel = :idHotel WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") int id, @Param("nombre") String nombre, @Param("correoElectronico") String correoElectronico,
                        @Param("tipo") TipoUsuario tipo, @Param("idHotel") Hotel idHotel);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (nombre, correo_electronico, tipo, id_hotel) " +
    "VALUES (:nombre, :correoElectronico, :tipo, :idHotel)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("correoElectronico") String correoElectronico,
    @Param("tipo") TipoUsuario tipo, @Param("idHotel") Hotel idHotel);

}
