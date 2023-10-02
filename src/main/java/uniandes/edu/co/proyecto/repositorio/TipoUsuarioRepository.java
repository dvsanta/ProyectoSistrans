package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer>{

        @Query(value = "SELECT * FROM tipos_usuarios", nativeQuery = true)
        Collection<TipoUsuario> darTiposUsuarios();

        @Query(value = "SELECT * FROM tipos_usuarios WHERE id = :id", nativeQuery = true)
        TipoUsuario darTipoUsuario(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = 
        "INSERT INTO tipos_usuarios(id,nombre)"+
         "VALUES (hoteles_sequence.nextval, :nombre)")
        void insertarTipoUsuario(@Param("nombre") String nombre);

        @Modifying
        @Transactional
        @Query(value = "UPDATE tipos_usuarios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
        void actualizarTipoUsuario(
                @Param("id") long id, 
                @Param("nombre") String nombre);


        @Modifying
        @Transactional
        @Query(value = "DELETE FROM tipos_usuarios WHERE id = :id", nativeQuery = true)
        void eliminarBar(@Param("id") long id);

}