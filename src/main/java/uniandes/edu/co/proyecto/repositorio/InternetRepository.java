package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.modelo.Piscina;

import java.util.Collection;

public interface InternetRepository extends JpaRepository<Internet, Integer> {

    @Query(value = "SELECT * FROM internet", nativeQuery = true)
    Collection<Internet> darInternets();

    @Query(value = "SELECT * FROM internet WHERE id = :id", nativeQuery = true)
    Internet darInternet(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE internet SET capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarInternet(@Param("id") Integer id, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internet (id,capacidad) VALUES (:id, :capacidad)", nativeQuery = true)
    void insertarInternet(@Param("id") Integer id, @Param("capacidad") Integer capacidad);
}
