package uniandes.edu.modelo;

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
    private TipoHabitacion tipoHabitacion;
    private Integer capacidad;
    private Double precioHabitacion;
    private Double precioMinibar;
    private Double consumoTienda;
    private Boolean estaOcupada;

    public Habitacion(){;}

    public Habitacion(TipoHabitacion tipoHabitacion, Integer capacidad, Double precioHabitacion, Double precioMinibar,
            Double consumoTienda, Boolean estaOcupada) {
        this.tipoHabitacion = tipoHabitacion;
        this.capacidad = capacidad;
        this.precioHabitacion = precioHabitacion;
        this.precioMinibar = precioMinibar;
        this.consumoTienda = consumoTienda;
        this.estaOcupada = estaOcupada;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    public Double getPrecioHabitacion() {
        return precioHabitacion;
    }
    public void setPrecioHabitacion(Double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }
    public Double getPrecioMinibar() {
        return precioMinibar;
    }
    public void setPrecioMinibar(Double precioMinibar) {
        this.precioMinibar = precioMinibar;
    }
    public Double getConsumoTienda() {
        return consumoTienda;
    }
    public void setConsumoTienda(Double consumoTienda) {
        this.consumoTienda = consumoTienda;
    }
    public Boolean getEstaOcupada() {
        return estaOcupada;
    }
    public void setEstaOcupada(Boolean estaOcupada) {
        this.estaOcupada = estaOcupada;
    }

    
}
