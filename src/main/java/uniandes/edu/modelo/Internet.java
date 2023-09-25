package uniandes.edu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "internet")
public class Internet {
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double capacidad;

    public Internet(Double capacidad) {
        this.capacidad = capacidad;
    }

    public Internet()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    
}