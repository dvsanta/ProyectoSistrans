package uniandes.edu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscina")
public class Piscina {
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double profundidad;

    public Piscina(Double profundidad) {
        this.profundidad = profundidad;
    }

    public Piscina()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Double profundidad) {
        this.profundidad = profundidad;
    }

    

}
