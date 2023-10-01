package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Table;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer capacidad;
    private Double precio_habitacion;
    private Double precio_minibar;
    private Double consumos_tienda;
    private Boolean esta_ocupada;

    public Habitacion(){;}

    public Habitacion(Integer capacidad, Double precioHabitacion, Double precioMinibar,
            Double consumoTienda, Boolean estaOcupada) {
        this.capacidad = capacidad;
        this.precio_habitacion = precioHabitacion;
        this.precio_minibar = precioMinibar;
        this.consumos_tienda = consumoTienda;
        this.esta_ocupada = estaOcupada;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    public Double getPrecioHabitacion() {
        return precio_habitacion;
    }
    public void setPrecioHabitacion(Double precioHabitacion) {
        this.precio_habitacion = precioHabitacion;
    }
    public Double getPrecioMinibar() {
        return precio_minibar;
    }
    public void setPrecioMinibar(Double precioMinibar) {
        this.precio_minibar = precioMinibar;
    }
    public Double getConsumoTienda() {
        return consumos_tienda;
    }
    public void setConsumoTienda(Double consumoTienda) {
        this.consumos_tienda = consumoTienda;
    }
    public Boolean getEstaOcupada() {
        return esta_ocupada;
    }
    public void setEstaOcupada(Boolean estaOcupada) {
        this.esta_ocupada = estaOcupada;
    }

    
}
