package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Usuario;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    @Query(value = "SELECT * FROM usuarios", nativeQuery=true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery=true)
    Usuario darUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = 
    "INSERT INTO usuarios (id, nombre, correo_electronico, tipo, id_hotel) "+
    "VALUES ( hoteles_sequence.nextval , :nombre, :correo, :idTipoUsuario, :idHotel)", 
    nativeQuery = true)
    void insertarUsuario(
        @Param("nombre") String nombre,
        @Param("correo") String correo,
        @Param("idTipoUsuario") Integer idTipoUsuario,
        @Param("idHotel") Integer idHotel
    );

    @Modifying
    @Transactional
    @Query(value = 
    "UPDATE usuarios SET" +
        "nombre = :nombre,"+
        "correo_electronico = :correo,"+
        "tipo = :idTipoUsuario,"+
        "id_hotel = :idHotel" +
    "WHERE id = :id"
    ,nativeQuery=true)
    void actualizarUsuario(
        @Param("id") Integer id,
        @Param("nombre") String nombre,
        @Param("correo") String correo,
        @Param("idTipoUsuario") Integer idTipoUsuario,
        @Param("idHotel") Integer idHotel
    );


    @Modifying
    @Transactional
    @Query(value="DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsario(@Param("id") Integer id);
}
