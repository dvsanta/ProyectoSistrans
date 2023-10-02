package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.modelo.ReservaEspacio;

import java.util.Collection;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {

    @Query(value = "SELECT * FROM piscinas", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT * FROM piscinas WHERE id = :id", nativeQuery = true)
    Piscina darPiscina(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET profundidad = :profundidad WHERE id = :id", nativeQuery = true)
    void actualizarPiscina(@Param("id") Integer id, @Param("profundidad") Integer profundidad);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (id,profundidad) VALUES (:id, :profundidad)", nativeQuery = true)
    void insertarPiscina(@Param("id") Integer id, @Param("profundidad") Integer profundidad);


}
