package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Restaurante;

import java.util.Collection;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

    @Query(value = "SELECT * FROM restaurantes", nativeQuery = true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT * FROM restaurantes WHERE id = :id", nativeQuery = true)
    Restaurante darRestaurantes(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantes SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarRestaurantes(@Param("id") Integer id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurantes (id,tipo) VALUES (:id, :tipo)", nativeQuery = true)
    void insertarRestaurantes(@Param("id") Integer id, @Param("tipo") String tipo);
}
