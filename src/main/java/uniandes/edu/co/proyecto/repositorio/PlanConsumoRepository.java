package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;

import java.util.Collection;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo,Integer> {

    @Query(value = "SELECT * FROM planes_consumo", nativeQuery = true)
    Collection<PlanConsumo> darPlanesConsumo();

    @Query(value = "SELECT * FROM planes_consumo WHERE id = :id", nativeQuery = true)
    PlanConsumo darPlanConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes_consumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planes_consumo SET nombre = :nombre, tipo = :tipo, descuento_general = :descuento_general, " +//
            "id_hotel = :id_hotel, bebidas_ilimitadas = :bebidas_ilimitadas," +//
            "internet_ilimitado = :internet_ilimitado WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param("id") int id, @Param("nombre") String nombre, @Param("tipo") String tipo,
                               @Param("descuento_general") Integer descuento_general, @Param("id_hotel") Integer id_hotel,
                               @Param("bebidas_ilimitadas") Integer bebidas_ilimitadas, @Param("internet_ilimitado") Integer internet_ilimitado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes_consumo (id,nombre,tipo,descuento_general, id_hotel, bebidas_ilimitadas, internet_ilimitado)"+//
            " VALUES (hoteles_sequence.nextval, :nombre,:tipo,:descuento_general, :id_hotel, :bebidas_ilimitadas, :internet_ilimitado)", nativeQuery = true)
    void insertarPlanConsumo(@Param("nombre") String nombre, @Param("tipo") String tipo,
                               @Param("descuento_general") String descuento_general, @Param("id_hotel") Integer id_hotel,
                               @Param("bebidas_ilimitadas") Boolean bebidas_ilimitadas, @Param("internet_ilimitado") Boolean internet_ilimitado);
}
