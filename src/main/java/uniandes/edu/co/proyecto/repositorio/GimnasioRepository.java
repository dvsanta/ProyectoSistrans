package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.modelo.Piscina;

import java.util.Collection;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {

    @Query(value = "SELECT * FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasios WHERE id = :id", nativeQuery = true)
    Gimnasio darGimnasios(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET maquinas = :maquinas WHERE id = :id", nativeQuery = true)
    void actualizarGimansio(@Param("id") Integer id, @Param("maquinas") Integer maquinas);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (id,maquinas) VALUES (:id, :maquinas)", nativeQuery = true)
    void insertarGimnasio(@Param("id") Integer id, @Param("maquinas") Integer maquinas);


}
