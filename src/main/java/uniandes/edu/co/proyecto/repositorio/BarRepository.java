package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Bar;

import java.util.Collection;

public interface BarRepository extends JpaRepository<Bar,Integer> {

    @Query(value = "SELECT * FROM bares", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM bares WHERE id = :id", nativeQuery = true)
    Bar darBar(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarBar(@Param("id") Integer id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internet (id,tipo) VALUES (:id, :tipo)", nativeQuery = true)
    void insertarBar(@Param("id") Integer id, @Param("tipo") String tipo);
}
